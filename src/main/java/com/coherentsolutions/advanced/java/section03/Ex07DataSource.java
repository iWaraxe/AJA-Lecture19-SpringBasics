package com.coherentsolutions.advanced.java.section03;

/**
 * A simple DataSource class for demonstration.
 */
public class Ex07DataSource {

    private String dbName;

    public Ex07DataSource(String dbName) {
        this.dbName = dbName;
    }

    public void connect() {
        System.out.println("Connecting to database: " + dbName);
    }
}
