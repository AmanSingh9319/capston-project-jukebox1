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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SongService {


    //this method play a particular song it will take the song id which
    //you want to play
    public void playParticular(int songId) {
        Scanner sc = new Scanner(System.in);
        try {
            DatabaseService connection = new DatabaseService();
            Connection getConnection = connection.connect();
            String query = "select paths from songPath where id = ?";
            PreparedStatement ps = getConnection.prepareStatement(query);
            ps.setInt(1, songId);
            //executeQuery this predefines method
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //return the value from the table (path of song(query))..
                File file = new File(rs.getString(1));
                // create AudioInputStream object
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                // create clip reference
                Clip clip = AudioSystem.getClip();
                // open audioInputStream to the clip
                clip.open(audioStream);
                String response = "";
                while (!response.equals("X")) {
                    System.out.println("P = play/Resume, S = Pause, R = Reset, X= End");
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