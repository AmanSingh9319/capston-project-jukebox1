/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.main;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlayListRepository;
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
        // creating object of the play list repository
        PlayListRepository playListRepository = new PlayListRepository();
        //creating object os song servic class
        SongService songService = new SongService();
        System.out.println("-----------------All song------------------");
        System.out.println();
        //display method return value store this object
        List<Song> displayAllSong = songRepository.displayAllSong();
        displayFormat(displayAllSong);
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println();
        int task = 0;
        do {
            System.out.println("Press 1 to search in list");
            //System.out.println("Press 2 to create play list");
            //System.out.println("Press 3 to view play list");
            //System.out.println("Press 4 to insert song into play List");
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
                    if (choice == 1) {
                        System.out.println("Enter Genre name ::");
                        String genre = scanner.next();
                        List<Song> getGenre = songRepository.getSongSearchByGenre(displayAllSong, genre);
                        displayFormat(getGenre);
                        System.out.println("If you want to play song then press (Y/N)");
                        String option = scanner.next();
                        if (option.equals("Y")) {
                            System.out.println("please enter the song id which you want play");
                            int id = scanner.nextInt();
                            songService.playParticular(id);
                            System.out.println();
                        } else {
                            break;
                        }
                    } else if (choice == 2) {
                        System.out.println("Enter Album name ::");
                        String album = scanner.next();
                        List<Song> getAlbum = songRepository.getSongSearchByAlbumName(displayAllSong, album);
                        displayFormat(getAlbum);
                        System.out.println("If you want to play song then press (Y/N)");
                        String option = scanner.next();
                        if (option.equals("Y")) {
                            System.out.println("please enter the song id which you want play");
                            int id = scanner.nextInt();
                            songService.playParticular(id);
                            System.out.println();
                        } else {
                            break;
                        }
                    } else if (choice == 3) {
                        System.out.println("Enter Artist Name ::");
                        String artistName = scanner.next();
                        scanner.nextLine();
                        List<Song> getArtist = songRepository.getSongSearchByArtistName(displayAllSong, artistName);
                        displayFormat(getArtist);
                        System.out.println("If you want to play song then press (Y/N)");
                        String option = scanner.next();
                        if (option.equals("Y")) {
                            System.out.println("please enter the song id which you want play");
                            int id = scanner.nextInt();
                            songService.playParticular(id);
                            System.out.println();
                        } else {
                            break;
                        }
                    } else if (choice == 4) {
                        System.out.println("Enter Song Name ::");
                        scanner.nextLine();
                        String songName = scanner.nextLine();
                        List<Song> getSong = songRepository.getSongSearchBySongName(displayAllSong, songName);
                        displayFormat(getSong);
                        System.out.println("If you want to play song then press (Y/N)");
                        String option = scanner.next();
                        if (option.equals("Y")) {
                            System.out.println("please enter the song id which you want play");
                            int id = scanner.nextInt();
                            songService.playParticular(id);
                            System.out.println();
                        } else {
                            break;
                        }
                    } else System.out.println("Invalid input");
                    break;
                case 2:
                    System.out.println("Enter play list name::");
                    break;
                case 3:
                    System.out.println("********** Play List ********");
                    break;
                case 4:
                    break;
                case 5:
                    displayFormat(displayAllSong);
                    System.out.println("Please enter song id which you want to play");
                    int choice2 = scanner.nextInt();
                    System.out.println("---------------------------------------------------------------------");
                    songService.playParticular(choice2);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Successful Exit");
                    System.out.println("-------------------------------------------------------");
                    break;
            }
        } while (task < 6);
    }
    private static void displayFormat(List<Song> songList) {
        System.out.format("%-10s %-30s %-20s %-30s %-20s %-30s\n", "Id", "Name", "Duration", "AlbumName", "ArtistName", "Genre");
        for (Song song : songList) {
            System.out.format("%-10d %-30s %-20s %-30s %-20s %-30s\n", song.getId(), song.getName(), song.getDuration(), song.getAlbumName(), song.getArtistName(), song.getGenre());
        }
    }
}