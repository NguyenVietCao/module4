package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
//    @RequestMapping("")
//    public String showList(){
//        return "/songList";
//    }
    @GetMapping("/song")
    public String displayListSong(@PageableDefault(size = 2,sort = "id",direction = Sort.Direction.DESC) Pageable pageable,
                                  Model model) {
        model.addAttribute("songList", songService.displayList());
        return "songList";
    }
    @GetMapping("/create")
    public String getCreationForm(Model model){
        model.addAttribute("song",new Song());
        return "create";
    }
    @PostMapping("/create")
    public String createNewSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes){
        songService.addNewSong(song);
        redirectAttributes.addFlashAttribute("message","Thêm Mới Thành Công");
        return "redirect:/song";
    }
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable int id, RedirectAttributes redirectAttributes){
        if (songService.deleteSong(id)){
            redirectAttributes.addFlashAttribute("message","Xoá Thành công");
        }else {
            redirectAttributes.addFlashAttribute("message","Không tìm thấy id");
        }
        return "redirect:/song";
    }
}
