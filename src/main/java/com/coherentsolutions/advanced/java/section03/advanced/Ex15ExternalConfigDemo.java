package com.coherentsolutions.advanced.java.section03.advanced;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;

/**
 * Demonstrates externalized configuration.
 */
public class Ex15ExternalConfigDemo {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Add PropertySourcesPlaceholderConfigurer
        context.register(PropertySourcesPlaceholderConfigurer.class);
        context.register(Ex13AppConfig.class);

        // Load properties from file
        context.getEnvironment().setActiveProfiles("development");
        context.getEnvironment().getPropertySources().addLast(
                new org.springframework.core.io.support.ResourcePropertySource("classpath:application.properties"));

        context.refresh();

        Ex14ExternalConfigBean bean = context.getBean(Ex14ExternalConfigBean.class);
        bean.showMessage();

        context.close();
    }
}
