package com.coherentsolutions.advanced.java.section02.service;

import org.springframework.stereotype.Component;

/**
 * Implementation of MessageService that sends push notifications.
 */
@Component
public class PushNotificationService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Push Notification sent: " + message);
    }
}
