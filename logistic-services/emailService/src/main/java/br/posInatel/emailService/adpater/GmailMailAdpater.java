package br.posInatel.emailService.adpater;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import java.util.Properties;

@Service
@Profile("GMAIL")
public class GmailMailAdpater extends MailAdpater{
    @Override
    protected Properties getEmailHostProperties() {
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return props;
    }
}
