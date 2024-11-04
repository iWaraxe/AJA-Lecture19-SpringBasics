package com.coherentsolutions.advanced.java.section01.advanced;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Demonstrates the use of Spring Expression Language.
 */
public class Ex07SpELExample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        // Simple expression
        Expression exp = parser.parseExpression("'Hello Spring!'.concat(' Welcome to SpEL.')");
        String message = (String) exp.getValue();
        System.out.println(message);

        // Mathematical operation
        Expression exp2 = parser.parseExpression("100 * 2 + 400");
        int result = (int) exp2.getValue();
        System.out.println("Calculation result: " + result);
    }
}
