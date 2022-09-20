/*
 *Author Name: Aman Singh
 *Date:20-09-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    private int songId;
    private String songName;
    private String songDuration;
    private String albumName;
    private String artistName;
    private String genre;

    public Song() {
    }

    public Song(int songId, String songName, String songDuration, String albumName, String artistName, String genre) {
        this.songId = songId;
        this.songName = songName;
        this.songDuration = songDuration;
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = genre;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return songId == song.songId && Objects.equals(songName, song.songName) && Objects.equals(songDuration, song.songDuration) && Objects.equals(albumName, song.albumName) && Objects.equals(artistName, song.artistName) && Objects.equals(genre, song.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, songName, songDuration, albumName, artistName, genre);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", songDuration='" + songDuration + '\'' +
                ", albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
