package com.coherentsolutions.advanced.java.section03.advanced;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class demonstrating externalized properties.
 */
@Configuration
public class Ex13AppConfig {

    @Value("${app.message}")
    private String appMessage;

    @Value("${app.number}")
    private int appNumber;

    @Bean
    public Ex14ExternalConfigBean externalConfigBean() {
        return new Ex14ExternalConfigBean(appMessage);
    }
}
