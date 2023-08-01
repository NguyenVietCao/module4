package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.model.Status;
import com.example.song.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    private IStatusService statusService;

    @GetMapping("")
    public ResponseEntity<List<Status>> displayListSong() {

        return new ResponseEntity<>(statusService.displayStatus(), HttpStatus.OK);
    }
}
