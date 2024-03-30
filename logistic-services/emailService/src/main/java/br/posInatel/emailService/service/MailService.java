package br.posInatel.emailService.service;

import br.posInatel.emailService.adpater.MailAdpater;
import br.posInatel.emailService.model.MailRequestData;
import br.posInatel.emailService.rest.support.UtilityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    MailAdpater sender;

    public void sendMail(MailRequestData mailData) {
        if (mailData.getSender() == null ||
                mailData.getPassword() == null ||
                mailData.getTo() == null ||
                mailData.getContent() == null) {
            throw new UtilityException("Null values not allowed in MailRequestData.");
        }

        try {
            sender.sendMail(mailData);
        } catch(Exception e) {
            e.printStackTrace();
            throw new UtilityException("Error sending email: " + e.getMessage());
        }
        System.out.println("Email sent success.");
    }
}
