package com.coherentsolutions.advanced.java.section04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Configuration class to enable AOP and define beans.
 */
@Configuration
@EnableAspectJAutoProxy
public class Ex03AOPConfig {

    @Bean
    public Ex01SimpleService simpleService() {
        return new Ex01SimpleService();
    }

    @Bean
    public Ex02LoggingAspect loggingAspect() {
        return new Ex02LoggingAspect();
    }
}
