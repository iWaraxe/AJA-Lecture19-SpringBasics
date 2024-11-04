package com.coherentsolutions.advanced.java.section02.service;

/**
 * Implementation of MessageService that sends email messages.
 */
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}
