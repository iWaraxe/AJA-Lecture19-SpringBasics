package com.coherentsolutions.advanced.java.section01.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // Load the Spring application context from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve the event publisher bean
        Ex08EventPublisher publisher = context.getBean("eventPublisher", Ex08EventPublisher.class);

        // Publish the custom event
        System.out.println("Publishing Custom Event...");
        publisher.publish();
    }
}
