package com.coherentsolutions.advanced.java.section03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates bean configuration using @Configuration and @Bean.
 */
public class Ex12AppConfigDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Ex09AppConfig.class);

        Ex10Service service = context.getBean(Ex10Service.class);
        service.performAction();

        context.close();
    }
}
