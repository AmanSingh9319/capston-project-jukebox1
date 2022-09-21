/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    // the url of the database
    private static final String URL = "Jdbc:mysql://localhost:3306/jukebox";
    // the credentials of the user trying to log in to the database
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    // private field to store the reference of the connection object
    private Connection databaseConnection;

    public DatabaseService() {
        this.databaseConnection = null;
    }

    public Connection getDatabaseConnection() {
        return databaseConnection;
    }

    // Create a connection object using the driverManager class
    public boolean connect() {
        try {
            databaseConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return databaseConnection != null;
    }

    public void printConnectionsStatus() {
        if (databaseConnection != null) {
            System.out.println("connected to the database");
        } else {
            System.out.println("Not connected to the database");
        }
    }


}
