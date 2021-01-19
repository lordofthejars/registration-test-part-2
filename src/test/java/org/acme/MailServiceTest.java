package org.acme;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.mailer.MockMailbox;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MailServiceTest {
    
    @Inject
    MockMailbox mailbox;

    @Inject
    MailService mailService;

    @BeforeEach
    void init() {
        mailbox.clear();
    }

    @Test
    public void shouldSendAnEmail() {

        User user = new User("Alex", "alex@example.com", "abcd");

        mailService.sendEmail(user);

        assertThat(mailbox.getMessagesSentTo("alex@example.com"))
            .hasSize(1)
            .extracting("subject")
            .containsExactly("Your New Password");

    }

}
