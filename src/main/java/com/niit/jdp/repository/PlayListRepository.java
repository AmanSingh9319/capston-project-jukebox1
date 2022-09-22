/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;
import com.niit.jdp.service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        try {
            PreparedStatement ps = getConnection.prepareStatement(query);
            ps.setString(1, playListName);
            int row = ps.executeUpdate();
            if (row == 1) {
                System.out.println("Play List successful created");
            } else {
                System.out.println("Play List not created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // show play list
    public List<PlayList> showPlayList() {
        String playList = null;
        int count = 0;
        List<PlayList> playListName = new ArrayList<>();
        Connection getConnection = connection.connect();
        String query = "Select * from playList;";
        try {
            Statement st = getConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                playList = rs.getString(1);
                count++;
                playListName.add(new PlayList(playList, count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playListName;
    }
}