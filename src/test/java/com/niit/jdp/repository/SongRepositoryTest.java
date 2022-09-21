package com.niit.jdp.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongRepositoryTest {
    SongRepositoryTest songRepositoryTest = null;
    SongRepository songRepository;

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
    }

    @Test
    void getSongSearchByAlbumName() {
    }

    @Test
    void getSongSearchByArtistName() {
    }

    @Test
    void getSongSearchByGenre() {
    }

    @Test
    void displayAllSong() {
    }
}