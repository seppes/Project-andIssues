package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {
    @Id
    private int id;
    private String name;

    public Game() {
    }

    public Game(int id, String name) {
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
