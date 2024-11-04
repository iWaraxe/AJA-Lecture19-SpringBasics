package com.coherentsolutions.advanced.java.section03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class that defines beans using @Bean annotations.
 */
@Configuration
public class Ex09AppConfig {

    @Bean
    public Ex10Service myService() {
        return new Ex10Service(myRepository());
    }

    @Bean
    public Ex11Repository myRepository() {
        return new Ex11Repository();
    }
}
