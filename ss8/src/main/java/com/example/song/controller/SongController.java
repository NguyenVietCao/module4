package com.example.song.controller;

import com.example.song.dto.SongCreationDto;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/song")
@CrossOrigin(origins = "*")
public class SongController {
    @Autowired
    private ISongService songService;

    //    @RequestMapping("")
//    public String showList(){
//        return "/songList";
//    }

    @GetMapping("")
    public ResponseEntity<List<Song>> displayListSong() {

        return new ResponseEntity<>(songService.displayList(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> getCreationForm(@RequestBody Song song) {
//        model.addAttribute("songCreationDto", new SongCreationDto());
        try{
            songService.addNewSong(song);
            return ResponseEntity.status(HttpStatus.OK).body("add success");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("add Fail");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Song>> deleteProduct(@PathVariable("id") Integer id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        songService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public String createNewSong(@Valid @ModelAttribute SongCreationDto songCreationDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
//        new SongCreationDto().validate(songCreationDto, bindingResult);
//        if (bindingResult.hasErrors()) {
////            model.addAttribute("song", songCreationDto);
//            return "create";
//        }
//        Song song = new Song();
//        BeanUtils.copyProperties(songCreationDto, song);
//        songService.addNewSong(song);
//        redirectAttributes.addFlashAttribute("message", "Thêm Mới Thành Công");
//        return "redirect:/song";
//    }

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
        BeanUtils.copyProperties(songCreationDto, song);
        songService.editSong(song);
        redirectAttributes.addFlashAttribute("message", "Sửa Thành Công");
        return "redirect:/song";
    }
    @Transactional
    @GetMapping("/get")
    public ResponseEntity<Page<Song>> getALlProduct(@RequestParam(value = "page", defaultValue = "0") Integer page) {
//        Pageable pageable = PageRequest.of(page, 3, Sort.by(Sort.Order.desc("name")));
        Pageable pageable = PageRequest.of(page, 3, Sort.by(Sort.Order.asc("name")));


        Page<Song> contractsPage = songService.getPage(pageable);

        if (contractsPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractsPage, HttpStatus.OK);
    }
}
