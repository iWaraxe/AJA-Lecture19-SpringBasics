package com.coherentsolutions.advanced.java.section01;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Demonstrates basic JDBC operations using JdbcTemplate.
 */
public class Ex03JdbcTemplateExample {
    public static void main(String[] args) {
        // Setting up the data source
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate_db");
        dataSource.setUsername("bestuser");
        dataSource.setPassword("bestuser");

        // Creating JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // Executing a query
        String sql = "SELECT COUNT(*) FROM employees";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);

        System.out.println("Total users: " + count);
    }
}
