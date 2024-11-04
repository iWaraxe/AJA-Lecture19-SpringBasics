package com.coherentsolutions.advanced.java.section05.advanced.ex3;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * Enables method-level security.
 */
@Configuration
@EnableMethodSecurity
public class Ex05MethodSecurityConfig {
    // No additional code needed; this enables method-level security annotations
}
