package com.niit.jdp.model;

import java.util.List;

public interface SongInterface {
    // method
    public List<Song> getSongSearchBySongName(List<Song> songList, String songName);
}
