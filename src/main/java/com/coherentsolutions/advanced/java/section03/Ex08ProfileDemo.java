package com.coherentsolutions.advanced.java.section03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates activating profiles in Spring.
 */
public class Ex08ProfileDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Activate the 'development' profile
        context.getEnvironment().setActiveProfiles("development");

        // Register configuration class
        context.register(Ex06ProfileConfig.class);

        // Refresh the context to apply the configurations
        context.refresh();

        Ex07DataSource dataSource = context.getBean(Ex07DataSource.class);
        dataSource.connect();

        context.close();
    }
}
