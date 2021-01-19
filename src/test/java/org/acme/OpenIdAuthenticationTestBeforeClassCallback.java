package org.acme;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Optional;

import org.acme.api.OpenIdAuthentication;

import io.quarkus.test.junit.callback.QuarkusTestBeforeClassCallback;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class OpenIdAuthenticationTestBeforeClassCallback implements QuarkusTestBeforeClassCallback {

    @Override
    public void beforeClass(Class<?> testClass) {
        

        /**System.out.println("***");
        Annotation[] annotations = testClass.getAnnotations();

        Optional<Annotation> annotation = Arrays.stream(annotations)
            .filter(a -> a.annotationType().getSimpleName().equals(OpenIdAuthentication.class.getSimpleName()))
            .findFirst();

        annotation.ifPresent(a -> {
            OpenIdAuthentication openIdAuth =  (OpenIdAuthentication) a;

            System.out.println("OpenId Connect authentication logic with " + openIdAuth.username() + " " + openIdAuth.password());
            String accessToken = getToken(openIdAuth);

            final RequestSpecBuilder requestSpec = new RequestSpecBuilder();
            requestSpec.addHeader("Authorization", "Bearer " + accessToken);
            
            RestAssured.requestSpecification = requestSpec.build();
        });**/
        
    }

    private static String getToken(OpenIdAuthentication annotation) {
        return null;
    }
    
}
