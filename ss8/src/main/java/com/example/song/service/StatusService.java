package com.example.song.service;

import com.example.song.model.Status;
import com.example.song.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusService implements IStatusService {
    @Autowired
  private   IStatusRepository statusRepository;


    @Override
    public List<Status> displayStatus() {
        return statusRepository.findAll();
    }
}
