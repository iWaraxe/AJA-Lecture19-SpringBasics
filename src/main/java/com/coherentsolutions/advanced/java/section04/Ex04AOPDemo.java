package com.coherentsolutions.advanced.java.section04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates AOP logging in action.
 */
public class Ex04AOPDemo {

    public static void main(String[] args) {
        // Create the application context
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Ex03AOPConfig.class);

        // Retrieve the service bean
        Ex01SimpleService service = context.getBean(Ex01SimpleService.class);

        // Call the serve method
        String result = service.serve("World");
        System.out.println("Result: " + result);

        // Close the context
        context.close();
    }
}
