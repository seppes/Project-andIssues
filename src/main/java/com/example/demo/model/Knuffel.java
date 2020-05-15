package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Knuffel {
    @Id
    private int id;
    private String animalName;
    private String animalPrice;
    private String animalPic;
    private String animalDescription;


    public Knuffel(int id, String animalName, String animalPrice, String animalPic, String animalDescription) {
        this.id = id;
        this.animalName = animalName;
        this.animalPrice = animalPrice;
        this.animalPic = animalPic;
        this.animalDescription = animalDescription;
    }

    public Knuffel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalPrice() {
        return animalPrice;
    }

    public void setAnimalPrice(String animalPrice) {
        this.animalPrice = animalPrice;
    }

    public String getAnimalPic() {
        return animalPic;
    }

    public void setAnimalPic(String animalPic) {
        this.animalPic = animalPic;
    }

    public String getAnimalDescription() {
        return animalDescription;
    }

    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }
}
