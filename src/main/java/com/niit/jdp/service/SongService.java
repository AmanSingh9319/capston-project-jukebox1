/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SongService {
    // make a playing method
    public void playing() {
        Scanner sc = new Scanner(System.in);
        DatabaseService connection = new DatabaseService();
        Connection getConnection = connection.connect();
        String query = "select paths from songPath;";
        try {
            Statement st = getConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                File file = new File(rs.getString(1));
                // creat AudioInputStream object
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                // creat clip reference
                Clip clip = AudioSystem.getClip();
                String response = "";
                while (!response.equals("Q")) {
                    System.out.println("P = play/Resume, S = Pause, R = Reset, Q = Next, X= End");
                    response = sc.next();
                    switch (response) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(0);
                            clip.start();
                            break;
                        case ("Q"):
                            clip.close();
                            break;
                        case ("X"):
                            clip.stop();
                            return;
                        default:
                            System.out.println("Not a valid response");
                    }
                }
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void reversePlaying() {
        Scanner sc = new Scanner(System.in);
        try {
            DatabaseService connection = new DatabaseService();
            Connection getConnection = connection.connect();
            String query = "select paths from songPath order by songId desc;";
            Statement st = getConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                File file = new File(rs.getString(1));
                // create AudioInputStream object
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                // create clip reference
                Clip clip = AudioSystem.getClip();
                // open audioInputStream to the clip
                clip.open(audioStream);
                String response = "";
                while (!response.equals("Q")) {
                    System.out.println("P = play/Resume, S = Pause, R = Reset, Q = Next, X= End");
                    response = sc.next();
                    switch (response) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(0);
                            clip.start();
                            break;
                        case ("Q"):
                            clip.close();
                            break;
                        case ("X"):
                            clip.stop();
                            return;
                        default:
                            System.out.println("Not a valid response");
                    }
                }
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void randomPlay() {
        Scanner sc = new Scanner(System.in);
        try {
            DatabaseService connection = new DatabaseService();
            Connection getConnection = connection.connect();
            String query = "select paths from songPath order by RAND ();";
            Statement st = getConnection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                File file = new File(rs.getString(1));
                // create AudioInputStream object
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

                // create clip reference
                Clip clip = AudioSystem.getClip();

                // open audioInputStream to the clip
                clip.open(audioStream);

                String response = "";

                while (!response.equals("Q")) {
                    System.out.println("P = play/Resume, S = Pause, R = Reset, Q = Next, X= End");

                    response = sc.next();

                    switch (response) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(0);
                            clip.start();
                            break;
                        case ("Q"):
                            clip.close();
                            break;
                        case ("X"):
                            clip.stop();
                            return;
                        default:
                            System.out.println("Not a valid response");
                    }
                }
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}