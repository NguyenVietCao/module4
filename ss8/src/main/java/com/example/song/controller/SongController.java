package com.example.song.controller;

import com.example.song.dto.SongCreationDto;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    //    @RequestMapping("")
//    public String showList(){
//        return "/songList";
//    }
    @GetMapping("/song")
    public String displayListSong(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                  Model model) {
        model.addAttribute("songList", songService.displayList());
        return "songList";
    }

    @GetMapping("/create")
    public String getCreationForm(Model model) {
        model.addAttribute("songCreationDto", new SongCreationDto());
        return "create";
    }

    @PostMapping("/create")
    public String createNewSong(@Valid @ModelAttribute SongCreationDto songCreationDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new SongCreationDto().validate(songCreationDto, bindingResult);
        if (bindingResult.hasErrors()) {
//            model.addAttribute("song", songCreationDto);
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songCreationDto, song);
        songService.addNewSong(song);
        redirectAttributes.addFlashAttribute("message", "Thêm Mới Thành Công");
        return "redirect:/song";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (songService.deleteSong(id)) {
            redirectAttributes.addFlashAttribute("message", "Xoá Thành công");
        } else {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy id");
        }
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String getFormEdit(@PathVariable int id, RedirectAttributes redirectAttributes, Model model) {
        if (songService.getSongById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Khong tim thay id");
            return "redirect:/song";
        } else {
            SongCreationDto songCreationDto = new SongCreationDto();
            BeanUtils.copyProperties(songService.getSongById(id), songCreationDto);
            model.addAttribute("songCreationDto", songCreationDto);
            return "edit";
        }

    }

    @PostMapping("/edit")
    public String editSong(@Valid @ModelAttribute SongCreationDto songCreationDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new SongCreationDto().validate(songCreationDto, bindingResult);
        if (bindingResult.hasErrors()) {
    return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songCreationDto,song);
        songService.editSong(song);
        redirectAttributes.addFlashAttribute("message", "Sửa Thành Công");
        return "redirect:/song";
    }
}
