package com.coherentsolutions.advanced.java.section01.advanced;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Publishes custom events.
 */
public class Ex08EventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    public void publish() {
        CustomEvent event = new CustomEvent(this);
        publisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}

/**
 * Custom event class.
 */
class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "My Custom Event";
    }
}
