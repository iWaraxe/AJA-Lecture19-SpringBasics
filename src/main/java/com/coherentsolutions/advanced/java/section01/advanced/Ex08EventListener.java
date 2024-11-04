package com.coherentsolutions.advanced.java.section01.advanced;

import org.springframework.context.ApplicationListener;

/**
 * Listens for custom events.
 */
public class Ex08EventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Received: " + event.toString());
    }
}
