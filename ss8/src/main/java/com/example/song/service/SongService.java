package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> displayList() {
        return songRepository.findAll();
    }

    @Override
    public void addNewSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public boolean deleteSong(int id) {
        songRepository.deleteById(id);
        return true;
    }

    @Override
    public void editSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song getSongById(int id) {
        return songRepository.findById(id).get();
    }
}
