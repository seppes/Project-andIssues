package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Video {

    @Id
    private int id;
    private String name;
    private String titelVideo1;
    private String titelVideo2;
    private String titelVideo3;
    private String video1;
    private String video2;
    private String video3;
    private String fotoDier;


    public Video() {
    }

    public Video(int id, String name, String titelVideo1, String titelVideo2, String titelVideo3, String fotoDier, String video1, String video2, String video3) {
        this.id = id;
        this.name = name;
        this.titelVideo1 = titelVideo1;
        this.titelVideo2 = titelVideo2;
        this.titelVideo3 = titelVideo3;
        this.video1 = video1;
        this.video2 = video2;
        this.video3 = video3;
        this.fotoDier = fotoDier;

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

    public String getTitelVideo1() {
        return titelVideo1;
    }

    public void setTitelVideo1(String titelVideo1) {
        this.titelVideo1 = titelVideo1;
    }

    public String getTitelVideo2() {
        return titelVideo2;
    }

    public void setTitelVideo2(String titelVideo2) {
        this.titelVideo2 = titelVideo2;
    }

    public String getTitelVideo3() {
        return titelVideo3;
    }

    public void setTitelVideo3(String titelVideo3) {
        this.titelVideo3 = titelVideo3;
    }

    public String getVideo1() {
        return video1;
    }

    public void setVideo1(String video1) {
        this.video1 = video1;
    }

    public String getVideo2() {
        return video2;
    }

    public void setVideo2(String video2) {
        this.video2 = video2;
    }

    public String getVideo3() {
        return video3;
    }

    public void setVideo3(String video3) {
        this.video3 = video3;
    }

    public String getFotoDier() {
        return fotoDier;
    }

    public void setFotoDier(String fotoDier) {
        this.fotoDier = fotoDier;
    }


}
