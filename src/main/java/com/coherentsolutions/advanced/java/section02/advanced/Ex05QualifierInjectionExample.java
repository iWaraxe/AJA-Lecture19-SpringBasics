package com.coherentsolutions.advanced.java.section02.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.coherentsolutions.advanced.java.section02.service.MessageService;

/**
 * Client class using @Qualifier.
 */
@Component
public class Ex05QualifierInjectionExample {
    private MessageService messageService;

    /**
     * Constructor-based Dependency Injection with @Qualifier.
     *
     * @param messageService the MessageService implementation to use
     */
    @Autowired
    public Ex05QualifierInjectionExample(@Qualifier("smsService") MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Sends a message using the injected MessageService.
     *
     * @param message the message to send
     */
    public void processMessages(String message) {
        messageService.sendMessage(message);
    }

    /**
     * Main method to run the application.
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.coherentsolutions.advanced.java.section02");
        context.scan("com.coherentsolutions.advanced.java.section02.advanced");
        context.refresh();

        Ex05QualifierInjectionExample app = context.getBean(Ex05QualifierInjectionExample.class);
        app.processMessages("Hello via @Qualifier!");

        context.close();
    }
}
