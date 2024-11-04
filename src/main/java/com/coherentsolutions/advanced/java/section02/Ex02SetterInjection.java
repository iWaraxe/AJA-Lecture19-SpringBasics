package com.coherentsolutions.advanced.java.section02;

import com.coherentsolutions.advanced.java.section02.service.MessageService;
import com.coherentsolutions.advanced.java.section02.service.SMSService;

/**
 * Client class that depends on MessageService.
 */
public class Ex02SetterInjection {
    private MessageService messageService;

    /**
     * Setter for Dependency Injection.
     *
     * @param messageService the MessageService implementation to set
     */
    public void setMessageService(MessageService messageService) {
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
     * Main method to demonstrate setter-based DI.
     */
    public static void main(String[] args) {
        Ex02SetterInjection app = new Ex02SetterInjection();

        // Injecting the dependency
        app.setMessageService(new SMSService());

        // Using the service
        app.processMessages("Hello via Setter Injection!");
    }
}
