package org.acme;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.NativeImageTest;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

@NativeImageTest
public class NativeRegistrationResourceIT {

    @Test
    public void shouldRegisterAUser() {
        
        final User user = new User();
        user.username = "Alex";
        user.email = "asotobu@example.com";

        given()
          .body(user)
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
          .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .when().post()
          .then()
             .statusCode(Status.CREATED.getStatusCode());
    }

}