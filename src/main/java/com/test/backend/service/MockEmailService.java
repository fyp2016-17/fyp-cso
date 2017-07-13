package com.test.backend.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by r0ot_h3x49 on 4/9/2017.
 */
public class MockEmailService extends AbstractEmailService {

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        System.out.println("Simulating an email service ...");
        System.out.println(message.toString());
        System.out.println("Email sent.");
    }
}
