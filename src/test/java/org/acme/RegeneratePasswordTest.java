package org.acme;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class RegeneratePasswordTest {
    
    @InjectMock
    PasswordGenerator passwordGenerator;

    @Inject
    RegeneratePassword regeneratePassword;

    @Test
    public void shouldGenerateANewPassword() {
        
        Mockito.when(passwordGenerator.generate()).thenReturn("my-secret").thenReturn("password");
        
        PanacheMock.mock(User.class);
        User user = new User("Alex", "alex@example.com", "my_super_password");
        Mockito.when(User.findUserByUsername("Alex")).thenReturn(Optional.of(user));

        regeneratePassword.regenerate("Alex");

        PanacheMock.verify(User.class, Mockito.times(1)).findUserByUsername("Alex");
        assertThat(user.password).isEqualTo("my-secret");

    }

}
