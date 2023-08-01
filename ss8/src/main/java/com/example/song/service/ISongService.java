package com.example.song.service;

import com.example.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    List<Song> displayList();

    void addNewSong(Song song);

    boolean deleteSong(int id);

    void editSong(Song song);

    Song getSongById(int id);

    void deleteById(Integer id);

    Page<Song> getPage(Pageable pageable);
}
