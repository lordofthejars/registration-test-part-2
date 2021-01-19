package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api")
@RegisterRestClient
@ApplicationScoped
public interface BannedUserClient {
    @GET @Path("/{username}")
    @Produces(MediaType.TEXT_PLAIN)
    String isBanned(@PathParam("username") String username);
}
