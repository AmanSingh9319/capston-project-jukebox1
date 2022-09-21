/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.main;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.SongRepository;

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

        System.out.println("---------All song----------");
        List<Song> listNames = songRepository.displayAllSong();
        for (Song listName : listNames) {
            System.out.println("listName = " + listName);
        }

        int task = 0;
        do {

            System.out.println("Press 1 to search in list");
            System.out.println("Press 2 to create play list");
            System.out.println("Press 3 to view play list");
            System.out.println("Press 4 to insert song into play List");
            System.out.println("Press 5 to Play a Song");
            System.out.println("Press 6 to Exit");
            task = scanner.nextInt();


        } while (task < 0);


    }
}

