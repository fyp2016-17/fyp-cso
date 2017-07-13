package com.test.backend.service;

import com.test.web.domain.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by r0ot_h3x49 on 4/9/2017.
 */
public interface EmailService {

    public void sendFeedbackEmail(FeedbackPojo feedback);

    public void sendGenericEmailMessage(SimpleMailMessage message);
}
