package com.coherentsolutions.advanced.java.section03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration class demonstrating the use of profiles.
 */
@Configuration
public class Ex06ProfileConfig {

    @Bean
    @Profile("development")
    public Ex07DataSource devDataSource() {
        System.out.println("Development DataSource Bean Created");
        return new Ex07DataSource("DevelopmentDB");
    }

    @Bean
    @Profile("production")
    public Ex07DataSource prodDataSource() {
        System.out.println("Production DataSource Bean Created");
        return new Ex07DataSource("ProductionDB");
    }
}
