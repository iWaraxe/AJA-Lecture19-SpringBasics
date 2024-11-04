package com.coherentsolutions.advanced.java.section03;

/**
 * A service class that depends on a repository.
 */
public class Ex10Service {

    private final Ex11Repository repository;

    public Ex10Service(Ex11Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        System.out.println("Service is using repository: " + repository.getData());
    }
}
