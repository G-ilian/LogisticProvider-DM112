package br.posInatel.emailService.interfaces;

import br.posInatel.emailService.model.MailRequestData;

public interface Email {
    void sendMail(MailRequestData mailData);
}
