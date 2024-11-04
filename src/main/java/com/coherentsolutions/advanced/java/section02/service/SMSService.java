package com.coherentsolutions.advanced.java.section02.service;

import org.springframework.stereotype.Component;

/**
 * Implementation of MessageService that sends SMS messages.
 */
@Component("smsService")
public class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS sent: " + message);
    }
}