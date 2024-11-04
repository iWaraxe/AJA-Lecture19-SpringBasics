package com.coherentsolutions.advanced.java.section03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates the difference between singleton and prototype bean scopes.
 */
public class Ex03BeanScopeDemo {

    public static void main(String[] args) {
        // Create the application context (container)
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.coherentsolutions.advanced.java.section03");

        // Retrieve singleton beans
        Ex01SingletonBean singletonBean1 = context.getBean(Ex01SingletonBean.class);
        Ex01SingletonBean singletonBean2 = context.getBean(Ex01SingletonBean.class);

        singletonBean1.doSomething();
        singletonBean2.doSomething();

        System.out.println("Are singletonBean1 and singletonBean2 the same? " +
                (singletonBean1 == singletonBean2));

        // Retrieve prototype beans
        Ex02PrototypeBean prototypeBean1 = context.getBean(Ex02PrototypeBean.class);
        Ex02PrototypeBean prototypeBean2 = context.getBean(Ex02PrototypeBean.class);

        prototypeBean1.doSomething();
        prototypeBean2.doSomething();

        System.out.println("Are prototypeBean1 and prototypeBean2 the same? " +
                (prototypeBean1 == prototypeBean2));

        // Close the context
        context.close();
    }
}
