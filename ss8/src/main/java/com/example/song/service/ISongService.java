package com.example.song.service;

import com.example.song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> displayList();
    void addNewSong(Song song);
    void deleteSong(int id);
    void editSong(int id);
}
