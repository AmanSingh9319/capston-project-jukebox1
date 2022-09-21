/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
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
}
