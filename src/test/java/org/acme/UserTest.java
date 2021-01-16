package org.acme;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserTest {
    
    @Test
    @Transactional
    public void shouldFindUsersByUsername() {

        final User user = new User();
        user.username = "Alex";
        user.email = "asotobu@example.com";

        user.persist();

        Optional<User> foundUser = User.findUserByUsername("Alex");

        assertThat(foundUser)
            .isNotEmpty()
            .map(u -> u.email)
            .contains("asotobu@example.com");

    }

}
