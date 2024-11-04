package com.coherentsolutions.advanced.java.section04.advanced;

import com.coherentsolutions.advanced.java.section04.Ex01SimpleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates advanced AOP features.
 */
public class Ex07AOPAdvancedDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Ex06AOPConfigAdvanced.class);

        Ex01SimpleService service = context.getBean(Ex01SimpleService.class);
        String result = service.serve("Advanced AOP");
        System.out.println("Result: " + result);

        context.close();
    }
}
