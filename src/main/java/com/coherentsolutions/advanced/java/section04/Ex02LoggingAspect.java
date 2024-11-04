package com.coherentsolutions.advanced.java.section04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * An aspect that logs execution time of methods.
 */
@Aspect
public class Ex02LoggingAspect {

    /**
     * An advice that logs execution time of methods in the service package.
     *
     * @param joinPoint the join point representing the method execution
     * @return the result of the method execution
     * @throws Throwable if the method throws any exceptions
     */
    @Around("execution(* com.coherentsolutions.advanced.java.section04.Ex01SimpleService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // Proceed with the method execution
        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("Method " + joinPoint.getSignature() + " executed in " +
                (endTime - startTime) + "ms");

        return proceed;
    }
}
