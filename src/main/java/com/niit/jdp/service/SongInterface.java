package com.niit.jdp.service;

import com.niit.jdp.model.Song;

import java.util.List;

public interface SongInterface {
    //  abstraction method
    public List<Song> getSongSearchBySongName(List<Song> songList, String songName) throws SongNotFound;
}
