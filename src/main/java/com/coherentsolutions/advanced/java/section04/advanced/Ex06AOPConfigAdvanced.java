package com.coherentsolutions.advanced.java.section04.advanced;

import com.coherentsolutions.advanced.java.section04.Ex01SimpleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Advanced configuration with multiple aspects.
 */
@Configuration
@EnableAspectJAutoProxy
public class Ex06AOPConfigAdvanced {

    @Bean
    public Ex01SimpleService simpleService() {
        return new Ex01SimpleService();
    }

    @Bean
    public Ex05AdvancedLoggingAspect advancedLoggingAspect() {
        return new Ex05AdvancedLoggingAspect();
    }
}
