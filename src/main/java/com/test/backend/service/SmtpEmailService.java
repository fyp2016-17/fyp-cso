package com.test.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by r0ot_h3x49 on 4/9/2017.
 */
public class SmtpEmailService extends AbstractEmailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        System.out.println("Sending email for : {" + message + "}");
        mailSender.send(message);
        System.out.println("Email sent.");
    }
}
