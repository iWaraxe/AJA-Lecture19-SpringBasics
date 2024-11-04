package com.coherentsolutions.advanced.java.section01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Logging aspect that logs method execution.
 */
@Aspect
public class Ex05LoggingAspect {

    /**
     * Logs before any method execution in the section01 package.
     *
     * @param joinPoint Provides details of the method being called.
     */
    @Before("execution(* com.coherentsolutions.advanced.java.section01.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature().getName());
    }
}
