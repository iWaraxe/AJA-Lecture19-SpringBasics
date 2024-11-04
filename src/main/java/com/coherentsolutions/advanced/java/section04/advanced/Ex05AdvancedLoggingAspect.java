package com.coherentsolutions.advanced.java.section04.advanced;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * An aspect demonstrating different types of advice.
 */
@Aspect
public class Ex05AdvancedLoggingAspect {

    /**
     * Logs method entry.
     *
     * @param joinPoint the join point representing the method execution
     */
    @Before("execution(* com.coherentsolutions.advanced.java.section04.Ex01SimpleService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Entering Method: " + joinPoint.getSignature().getName());
    }

    /**
     * Logs method exit and return value.
     *
     * @param joinPoint the join point representing the method execution
     * @param result    the returned value from the method
     */
    @AfterReturning(pointcut = "execution(* com.coherentsolutions.advanced.java.section04.Ex01SimpleService.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Exiting Method: " + joinPoint.getSignature());
        System.out.println("Returned: " + result);
    }
}
