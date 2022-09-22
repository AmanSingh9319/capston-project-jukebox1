package com.niit.jdp.repository;


import com.niit.jdp.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


class SongRepositoryTest {
    SongRepositoryTest songRepositoryTest = null;
    SongRepository songRepository = new SongRepository();


    @BeforeEach
    void setUp() {
        songRepositoryTest = new SongRepositoryTest();
    }

    @AfterEach
    void tearDown() {
        songRepositoryTest = null;
        songRepository = null;
    }

    @Test
    void getSongSearchBySongName() {
        List<Song> listNames = songRepository.displayAllSong();
        List<Song> songList = songRepository.getSongSearchBySongName(listNames, "joy");
        assertEquals(songList, songRepository.getSongSearchBySongName(listNames, "joy"));

    }

    @Test
    void getSongSearchByAlbumName() {
        List<Song> listNames = songRepository.displayAllSong();
        List<Song> listAlbum = songRepository.getSongSearchByAlbumName(listNames, "hello eorld");
        assertEquals(listAlbum, songRepository.getSongSearchByAlbumName(listAlbum, "Despacita"));
    }

    @Test
    void getSongSearchByArtistName() {
        List<Song> listName = songRepository.displayAllSong();
        List<Song> listArtist = songRepository.getSongSearchByArtistName(listName, "mak");
        assertEquals(listArtist, songRepository.getSongSearchByArtistName(listArtist, "jack"));
    }

    @Test
    void getSongSearchByGenre() {
        List<Song> listName = songRepository.displayAllSong();
        List<Song> listgenre = songRepository.getSongSearchByGenre(listName, "pop");
        assertEquals(listgenre, songRepository.getSongSearchByGenre(listgenre, "rock"));
    }

    @Test
    void displayAllSong() {
        List<Song> listName = songRepository.displayAllSong();
        assertEquals(listName, listName);

    }
}