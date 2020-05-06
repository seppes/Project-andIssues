package com.example.demo.model;

public class Knuffel {
    private int id;
    private String KnuffelNaam;
    private String KnuffelPrijs;


    public Knuffel(int id, String KnuffelNaam, String KnuffelPrijs) {
        this.id = id;
        this.KnuffelNaam = KnuffelNaam;
        this.KnuffelPrijs = KnuffelPrijs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKnuffelNaam() {
        return KnuffelNaam;
    }

    public void setKnuffelNaam(String KnuffelNaam) {
        this.KnuffelNaam = KnuffelNaam;
    }

    public String getKnuffelPrijs() {
        return KnuffelPrijs;
    }

    public void setKnuffelPrijs(String KnuffelPrijs) {
        this.KnuffelPrijs = KnuffelPrijs;
    }
}
