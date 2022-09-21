/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.main;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.SongService;

import java.util.List;
import java.util.Scanner;

public class JukeBoxImpl {
    public static void main(String[] args) {

        //used for blue colour in output
        System.out.println("\u001B[34m");
        //creating scanner object for take input from user
        Scanner scanner = new Scanner(System.in);

        // creating object of song repository class for call method
        SongRepository songRepository = new SongRepository();
        //creating object os song servic class
        SongService songService = new SongService();

        System.out.println("-----------------All song------------------");
        System.out.println();
        List<Song> displayAllSong = songRepository.displayAllSong();

        for (Song listName : displayAllSong) {
            System.out.println(listName);
        }
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println();
        int task = 0;
        do {

            System.out.println("Press 1 to search in list");
            System.out.println("Press 2 to create play list");
            System.out.println("Press 3 to view play list");
            System.out.println("Press 4 to insert song into play List");
            System.out.println("Press 5 to Play a Song");
            System.out.println("Press 6 to Exit");
            task = scanner.nextInt();
            System.out.println("--------------------------------------------------------------------------");
            switch (task) {
                case 1:
                    System.out.println("Press 1 to Search song details-by Genre");
                    System.out.println("Press 2 to Search song detail-by Album");
                    System.out.println("Press 3 to Search song detail by-Artist Name");
                    System.out.println("Press 4 to Search song detail by-Song Name");
                    int choice = scanner.nextInt();
                    System.out.println("------------------------------------------------------------------------");


            }
        } while (task < 6);
    }
}

