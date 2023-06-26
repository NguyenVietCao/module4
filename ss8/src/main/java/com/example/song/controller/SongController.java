package com.example.song.controller;

import com.example.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @RequestMapping("")
    public String showList(){
        return "songList";
    }
    @GetMapping("/song")
    public String displayListSong(@PageableDefault(size = 2,sort = "id",direction = Sort.Direction.DESC) Pageable pageable,
                                  Model model) {
        model.addAttribute("songList", songService.displayList());
        return "songList";
    }
}
