/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayListRepository {
    /*
     * given play list add into database
     * add song into playlist table
     * show all playList from dataBase
     * get all song from play List
     */

    DatabaseService databaseService = new DatabaseService();


    // for adding PlayList into dataBase
    public void addIntoDatabase(String playListName) {
        Connection getConnection = databaseService.connect();
        String query = "Insert into playList values(?);";
        try {
            PreparedStatement preparedStatement = getConnection.prepareStatement(query);
            preparedStatement.setString(1, playListName);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                System.out.println("Play List successful created");
            } else {
                System.out.println("Play List not created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

