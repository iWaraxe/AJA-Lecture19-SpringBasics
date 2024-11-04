package com.coherentsolutions.advanced.java.section05.advanced.ex2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A simple REST controller that returns a greeting message.
 */
@RestController
public class Ex02HelloController {

    /**
     * Handles GET requests to "/hello".
     *
     * @return a greeting message
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Security!";
    }
}
