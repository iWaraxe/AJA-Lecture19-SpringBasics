package com.coherentsolutions.advanced.java.section03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates bean lifecycle in action.
 */
public class Ex05LifecycleDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.coherentsolutions.advanced.java.section03");

        Ex04LifecycleBean lifecycleBean = context.getBean(Ex04LifecycleBean.class);
        lifecycleBean.performTask();

        // Close the context to trigger @PreDestroy
        context.close();
    }
}
