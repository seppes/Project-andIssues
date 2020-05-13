package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Knuffel {
    @Id
    private int id;
    private String KnuffelNaam;
    private String KnuffelPrijs;
    private String KnuffelFoto;
    private String KnuffelBeschrijving;


    public Knuffel(int id, String KnuffelNaam, String KnuffelPrijs, String KnuffelFoto, String KnuffelBeschrijving) {
        this.id = id;
        this.KnuffelNaam = KnuffelNaam;
        this.KnuffelPrijs = KnuffelPrijs;
        this.KnuffelFoto = KnuffelFoto;
        this.KnuffelBeschrijving = KnuffelBeschrijving;
    }

    public Knuffel() {
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

    public String getKnuffelFoto() {
        return KnuffelFoto;
    }

    public void setKnuffelFoto(String knuffelFoto) {
        KnuffelFoto = knuffelFoto;
    }

    public String getKnuffelBeschrijving() {
        return KnuffelBeschrijving;
    }

    public void setKnuffelBeschrijving(String knuffelBeschrijving) {
        KnuffelBeschrijving = knuffelBeschrijving;
    }
}
