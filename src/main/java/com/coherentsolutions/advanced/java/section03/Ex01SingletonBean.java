package com.coherentsolutions.advanced.java.section03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * A singleton-scoped bean example.
 */
@Component
public class Ex01SingletonBean {

    public Ex01SingletonBean() {
        System.out.println("Singleton Bean Instance Created: " + this);
    }

    public void doSomething() {
        System.out.println("Singleton Bean Method Called: " + this);
    }
}
