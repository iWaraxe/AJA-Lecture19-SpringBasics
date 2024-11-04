package com.coherentsolutions.advanced.java.section02;

import com.coherentsolutions.advanced.java.section02.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


/**
 * Client class demonstrating Spring's DI with annotations.
 */
@Component
public class Ex03SpringDIExample {
    private MessageService messageService;

    /**
     * Constructor-based Dependency Injection with @Autowired.
     *
     * @param messageService the MessageService implementation to use
     */
    @Autowired
    public Ex03SpringDIExample(@Qualifier("smsService") MessageService messageService) {
        this.messageService = messageService;
    }

    //@Autowired
    public void setMessageService(@Qualifier("smsService") MessageService messageService) {
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
     * Main method to run the Spring application.
     */
    public static void main(String[] args) {
        // Creating the application context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.coherentsolutions.advanced.java.section02");
        context.refresh();

        // Retrieving the bean
        Ex03SpringDIExample app = context.getBean(Ex03SpringDIExample.class);

        // Using the service
        app.processMessages("Hello via Spring DI!");

        // Closing the context
        context.close();
    }
}
