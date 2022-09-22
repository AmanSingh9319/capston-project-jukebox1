/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;

public class PlayListRepository {
    /*
     * given play list add into database
     * add song into playlist table

     * show all playList from dataBase
     * get all song from play List
     */

    DatabaseService connection = new DatabaseService();

    // for adding PlayList into dataBase
    public void addIntoDatabase(String playListName) {
        Connection getConnection = connection.connect();
        String query = "Insert into playList values(?);";

    }

}