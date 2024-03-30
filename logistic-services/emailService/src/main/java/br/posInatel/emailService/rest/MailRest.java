package br.posInatel.emailService.rest;

import br.posInatel.emailService.interfaces.Email;
import br.posInatel.emailService.model.MailRequestData;
import br.posInatel.emailService.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MailRest implements Email {

    @Autowired
    private MailService service;

    @Override
    @PostMapping(value="/sendEmail")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMail(@RequestBody MailRequestData mailData) {
        service.sendMail(mailData);
    }

}
