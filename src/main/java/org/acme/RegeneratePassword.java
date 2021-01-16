package org.acme;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class RegeneratePassword {
    
    @Inject
    PasswordGenerator passwordGenerator;

    @Transactional
    public void regenerate(String username) {

        final Optional<User> user = User.findUserByUsername(username);
        user.map( u -> {
            String newPassword = passwordGenerator.generate();
            u.password = newPassword;
            return u;
        });

    }

}