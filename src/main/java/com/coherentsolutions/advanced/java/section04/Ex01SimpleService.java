package com.coherentsolutions.advanced.java.section04;

/**
 * A simple service class to demonstrate AOP.
 */
public class Ex01SimpleService {

    /**
     * Simulates some business logic.
     *
     * @param name the name to process
     * @return a greeting message
     */
    public String serve(String name) {
        System.out.println("Executing serve method");
        return "Hello, " + name + "!";
    }
}
