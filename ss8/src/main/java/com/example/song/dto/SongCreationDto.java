package com.example.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SongCreationDto implements Validator {
    private int id;

//    @Pattern(regexp = "^([\\w\\s]){1,800}$")
    private String songName;

//    @Pattern(regexp = "^([\\w\\s]){1,300}$")
    private String singer;

//    @Pattern(regexp = "^([\\w\\s]){1,1000}$")
    private String kindOfMusic;

    public SongCreationDto() {
    }

    public SongCreationDto(String songName, String singer, String kindOfMusic) {
        this.songName = songName;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongCreationDto songCreationDto = (SongCreationDto) target;
        if (!songCreationDto.getSongName().matches("^([\\w\\s]){1,800}$")) {
            errors.rejectValue("songName", "songName", "khong phai ten bai hat");
        }
        if (!songCreationDto.getSinger().matches("^([\\w\\s]){1,300}$")) {
            errors.rejectValue("singer", "singer", "khong phai ten ca si");
        }
        if (!songCreationDto.getKindOfMusic().matches("^([\\w\\s]){1,1000}$")) {
            errors.rejectValue("kindOfMusic", "kindOfMusic", "khong phai loai nhac");
        }
    }
}
