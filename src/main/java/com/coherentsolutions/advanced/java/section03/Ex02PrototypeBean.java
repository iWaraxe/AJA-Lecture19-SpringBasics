package com.coherentsolutions.advanced.java.section03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * A prototype-scoped bean example.
 */
@Component
@Scope("prototype")
public class Ex02PrototypeBean {

    public Ex02PrototypeBean() {
        System.out.println("Prototype Bean Instance Created: " + this);
    }

    public void doSomething() {
        System.out.println("Prototype Bean Method Called: " + this);
    }
}
