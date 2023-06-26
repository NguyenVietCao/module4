package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> displayList() {
        return null;
    }

    @Override
    public void addNewSong(Song song) {

    }

    @Override
    public void deleteSong(int id) {

    }

    @Override
    public void editSong(int id) {

    }
}
