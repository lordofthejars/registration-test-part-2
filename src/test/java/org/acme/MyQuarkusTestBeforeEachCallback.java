package org.acme;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.junit.callback.QuarkusTestBeforeEachCallback;
import io.quarkus.test.junit.callback.QuarkusTestMethodContext;
import io.quarkus.test.junit.mockito.InjectMock;

public class MyQuarkusTestBeforeEachCallback implements QuarkusTestBeforeEachCallback {

    @InjectMock
    @RestClient
    BannedUserClient bannedUserClient;

    @Override
    public void beforeEach(QuarkusTestMethodContext context) {

        System.out.println(bannedUserClient);

        System.out.println("Executing " + context.getTestMethod());
        Annotation[] annotations = context.getTestInstance().getClass().getAnnotations();

        Arrays.stream(annotations)
            .forEach(System.out::println);

    }
    
}
