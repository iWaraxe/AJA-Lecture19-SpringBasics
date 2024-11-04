package com.coherentsolutions.advanced.java.section02.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.coherentsolutions.advanced.java.section02.service.MessageService;

/**
 * Client class using field injection.
 */
@Component
public class Ex04FieldInjectionExample {
    @Autowired
    @Qualifier("smsService")
    private MessageService messageService;

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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.coherentsolutions.advanced.java.section02");

        Ex04FieldInjectionExample app = context.getBean(Ex04FieldInjectionExample.class);
        app.processMessages("Hello via Field Injection!");

        context.close();
    }
}
