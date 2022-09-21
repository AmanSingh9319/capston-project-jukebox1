/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SongService {

    // make a playing method
    public void playing() {
        Scanner sc = new Scanner(System.in);
        DatabaseService connection = new DatabaseService();
        Connection getConnection = connection.connect();
        String query = "select paths from songPath;";
        try {
            Statement st = getConnection.createStatement();
            ResultSet rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}