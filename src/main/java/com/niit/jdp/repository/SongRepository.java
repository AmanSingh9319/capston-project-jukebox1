/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    /*
     * 1.Search Song by song name.
     * 2.Search song by album name
     * 3.Search song by artist name
     * 4.Search song by genre
     * 5.Display all song
     */


    // Creating Database Service object for calling getConnection method
    DatabaseService connection = new DatabaseService();

    // search song by name
    public List<Song> getSongSearchBySongName(List<Song> songList, String name) {
        Connection getConnection = connection.getDatabaseConnection();
        List<Song> songList1 = new ArrayList<>();
        for (Song song : songList) {
            System.out.println(song.getName());
            if (song.getName().equalsIgnoreCase(name)) {
                songList1.add(song);
            }
        }
        return songList1;
    }

    //search song by album name
    public List<Song> getSongSearchByAlbumName(List<Song> songList, String albumName) {
        Connection getConnection = connection.getDatabaseConnection();
        List<Song> songList1 = new ArrayList<>();
        for (Song song : songList) {
            System.out.println(song.getName());
            if (song.getName().equalsIgnoreCase(albumName)) {
                songList1.add(song);
            }
        }
        return songList1;
    }

    //search song by artist name
    public List<Song> getSongSearchByArtistName(List<Song> songList, String artistName) {
        Connection getConnection = connection.getDatabaseConnection();
        List<Song> songList1 = new ArrayList<>();
        for (Song song : songList) {
            if (song.getArtistName().equals(artistName)) {
                songList1.add(song);
            }
        }
        return songList1;
    }

    //search song by genre
    public List<Song> getSongSearchByGenre(List<Song> songList, String genre) {
        Connection getConnection = connection.getDatabaseConnection();
        List<Song> songList1 = new ArrayList<>();
        for (Song song : songList) {
            if (song.getGenre().equals(genre)) {
                songList1.add(song);
            }
        }
        return songList1;
    }

    // display all the song
    public List<Song> displayAllSong() {
        //creating object of list
        List<Song> songList = new ArrayList<>();
        Connection getConnection = connection.getDatabaseConnection();
        String sqlQuery = "SELECT * FROM song;";
        try {
            PreparedStatement preparedStatement = getConnection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String duration = resultSet.getString(3);
                String albumName = resultSet.getString(4);
                String artistname = resultSet.getString(5);
                String genre = resultSet.getString(6);

                songList.add(new Song(id, name, duration, albumName, artistname, genre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }


}