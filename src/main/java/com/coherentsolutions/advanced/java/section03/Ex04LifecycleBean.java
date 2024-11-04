package com.coherentsolutions.advanced.java.section03;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Demonstrates bean lifecycle callbacks.
 */
@Component
public class Ex04LifecycleBean {

    public Ex04LifecycleBean() {
        System.out.println("Ex04LifecycleBean Constructor Called: " + this);
    }

    @PostConstruct
    public void init() {
        System.out.println("Ex04LifecycleBean @PostConstruct Method Called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Ex04LifecycleBean @PreDestroy Method Called");
    }

    public void performTask() {
        System.out.println("Ex04LifecycleBean Method Called");
    }
}
