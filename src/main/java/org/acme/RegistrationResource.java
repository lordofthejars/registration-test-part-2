package org.acme;

import java.net.URI;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;


@Path("/registration")
public class RegistrationResource {

    @Inject
    PasswordGenerator passwordGenerator;

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUserByUsername(@PathParam("username") String username) {
        return User.findUserByUsername(username)
                    .map(u -> Response.ok(u).build())
                    .orElseGet(() -> Response.status(Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertUser(User user) {
        
        user.password = passwordGenerator.generate();
        user.persist();

        URI userUri = UriBuilder.fromResource(RegistrationResource.class)
                                          .path("/" + user.id).build();
        return Response
                    .created(userUri)
                    .build();
    }
}