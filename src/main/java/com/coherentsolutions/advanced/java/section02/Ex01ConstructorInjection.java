package com.coherentsolutions.advanced.java.section02;


import com.coherentsolutions.advanced.java.section02.service.EmailService;
import com.coherentsolutions.advanced.java.section02.service.MessageService;

/**
 * Client class that depends on MessageService.
 */
public class Ex01ConstructorInjection {
    private final MessageService messageService;

    /**
     * Constructor-based Dependency Injection.
     *
     * @param messageService the MessageService implementation to use
     */
    public Ex01ConstructorInjection(MessageService messageService) {
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
     * Main method to demonstrate constructor-based DI.
     */
    public static void main(String[] args) {
        // Injecting the dependency
        MessageService service = new EmailService();
        Ex01ConstructorInjection app = new Ex01ConstructorInjection(service);

        // Using the service
        app.processMessages("Hello via Constructor Injection!");
    }
}
