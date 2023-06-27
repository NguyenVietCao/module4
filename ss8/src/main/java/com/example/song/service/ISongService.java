package com.example.song.service;

import com.example.song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> displayList();

    void addNewSong(Song song);

    boolean deleteSong(int id);

    void editSong(Song song);

    Song getSongById(int id);
}
