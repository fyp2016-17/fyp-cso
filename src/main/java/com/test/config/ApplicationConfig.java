package com.test.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Abubakr on 4/11/2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.test.backend.persistence.repositories")
@EntityScan(basePackages = "com.test.backend.persistence.domain.backend")
@EnableTransactionManagement
public class ApplicationConfig {
}
