package com.example.song.model;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String names;

    public Status() {
    }

    public Status(int id) {
        this.id = id;
    }

    public Status(int id, String names) {
        this.id = id;
        this.names= names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names= names;
    }
}
