package com.coherentsolutions.advanced.java.section01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        greetingService.sayHello(); // This should trigger the logging aspect
    }
}
