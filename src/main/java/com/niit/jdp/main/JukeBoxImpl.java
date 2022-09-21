/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.main;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;

import java.util.List;

public class JukeBoxImpl {
    public static void main(String[] args) {

        //used for blue colour in output
        System.out.println("\u001B[34m");

        // creating object of song repository class for call method
        SongRepository songRepository = new SongRepository();

        System.out.println("---------All song----------");

        List<Song> listNames = songRepository.displayAllSong();

    }
}

