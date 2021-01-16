package org.acme;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PasswordGeneratorTest {
    
    @Inject
    PasswordGenerator passwordGenerator;

    @Test
    public void shouldGenerateARandomPassword() {
        final String password = passwordGenerator.generate();
        assertThat(password).containsPattern("[0-9A-F-]+");
    }

}
