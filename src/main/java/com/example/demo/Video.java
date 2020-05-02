package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Video {

    @Id
    String name;

    public Video() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
