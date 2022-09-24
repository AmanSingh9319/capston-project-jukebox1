/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;
import com.niit.jdp.model.Song;
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

    // Show play list
    public List<PlayList> ShowPlayList() {
        String playList = null;
        int count = 0;
        List<PlayList> playListsName = new ArrayList<>();
        Connection getConnection = databaseService.connect();
        String query = "Select * from playList;";
        try {
            Statement statement = getConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                playList = resultSet.getString(1);
                count++;
                playListsName.add(new PlayList(playList, count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playListsName;
    }

    //get song from playList
    public List<Song> getSongFromList(int playListId, List<Song> songList) {
        List<Song> getSong = new ArrayList<>();
        DatabaseService databaseService = new DatabaseService();
        Connection getConnection = databaseService.connect();
        String query = "Select * from playList1 where playListId = " + playListId;

        try {
            PreparedStatement preparedStatement = getConnection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int playListIdFromTable = resultSet.getInt(1);
                int songId = resultSet.getInt(2);
                for (Song song : songList) {
                    if (songId == song.getId()) {
                        getSong.add(song);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getSong;
    }
}

