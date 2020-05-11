package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Video {

    @Id
    private int id;
    private String name;


    public Video() {
    }

    public Video(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
