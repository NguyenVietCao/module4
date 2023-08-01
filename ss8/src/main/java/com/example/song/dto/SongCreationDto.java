package com.example.song.dto;

import com.example.song.model.Status;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class SongCreationDto implements Validator {

    private int id;
    private String songName;
    private String singer;
    private String likeNumber;

    private Status status;
    private String singTime;

    public SongCreationDto() {
    }

    public SongCreationDto(int id, String songName, String singer, String likeNumber, Status status, String singTime) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.likeNumber = likeNumber;
        this.status = status;
        this.singTime = singTime;
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

    public String getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(String likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSingTime() {
        return singTime;
    }

    public void setSingTime(String singTime) {
        this.singTime = singTime;
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

    }
}
