package com.coherentsolutions.advanced.java.section01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates basic IoC and DI in Spring.
 */
public class Ex01HelloSpring {
    public static void main(String[] args) {
        // Loading the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieving the bean from the Spring container
        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);

        // Using the bean
        greetingService.sayHello();

        //Old-fashioned
        MessageService messageService = new MessageService();
        GreetingServiceImpl greetingService2 = new GreetingServiceImpl();
        greetingService2.setMessageService(messageService);
        greetingService2.sayHello();
    }
}

/**
 * Service interface for greeting.
 */
interface GreetingService {
    void sayHello();
}

/**
 * Implementation of GreetingService.
 */
class GreetingServiceImpl implements GreetingService {
    private MessageService messageService;

    // Setter-based Dependency Injection
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void sayHello() {
        System.out.println(messageService.getMessage());
    }
}

/**
 * Service for providing messages.
 */
class MessageService {
    public String getMessage() {
        return "Hello, Spring Framework!";
    }
}
