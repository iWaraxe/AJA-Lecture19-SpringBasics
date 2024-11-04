package com.coherentsolutions.advanced.java.section03.advanced;

/**
 * A bean that uses external configuration.
 */
public class Ex14ExternalConfigBean {

    private String message;

    public Ex14ExternalConfigBean(String message) {
        this.message = message;
    }

    public void showMessage() {
        System.out.println("Message from properties: " + message);
    }
}
