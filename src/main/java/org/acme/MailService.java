package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

@ApplicationScoped
public class MailService {
    
    @Inject
    Mailer mailer;

    public void sendEmail(final User user) {
        mailer.send(
            Mail.withText(user.email, "Your New Password", 
                            String.format("New Password %s.", user.password))
        );
    }

}
