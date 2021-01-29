package org.acme;

import org.acme.api.OpenIdAuthentication;

import io.quarkus.test.junit.callback.QuarkusTestBeforeClassCallback;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class OpenIdAuthenticationTestBeforeClassCallback implements QuarkusTestBeforeClassCallback {

    @Override
    public void beforeClass(Class<?> testClass) {
        

        OpenIdAuthentication openIdAuth = testClass.getAnnotation(OpenIdAuthentication.class);

        if (openIdAuth != null) {

            String accessToken = getToken(openIdAuth);

            final RequestSpecBuilder requestSpec = new RequestSpecBuilder();
            requestSpec.addHeader("Authorization", "Bearer " + accessToken);
            
            RestAssured.requestSpecification = requestSpec.build();
        }
        
    }

    private static String getToken(OpenIdAuthentication annotation) {
        return null;
    }
    
}
