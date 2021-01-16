package org.acme;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RandomPasswordGenerator implements PasswordGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
    
}
