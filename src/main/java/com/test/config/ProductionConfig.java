package com.test.config;

import com.test.backend.service.EmailService;
import com.test.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Abubakr on 4/9/2017.
 */
@Configuration
@Profile("prod")
@PropertySource("classpath:i18n/production-config.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }

}
