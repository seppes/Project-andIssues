package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Video {

    @Id
    private int id;
    private String titel;
    private String videoFileName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Knuffel knuffel;

//    private String name;
//    private String fotoDier;

    public Video() {
    }

    public Video(int id, String titel, String videoFileName, Knuffel knuffel) {
        this.id = id;
        this.titel = titel;
        this.videoFileName = videoFileName;
        this.knuffel = knuffel;


    }

    public Video(int i, String waarom_wenen) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }


    public String getVideoFileName() {
        return videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }


    public Knuffel getKnuffel() {
        return knuffel;
    }

    public void setKnuffel(Knuffel knuffel) {
        this.knuffel = knuffel;
    }

}