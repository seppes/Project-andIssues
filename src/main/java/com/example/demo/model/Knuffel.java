package com.example.demo.model;

public class Knuffel {
    private int id;
    private String KnuffelNaam;
    private String KnuffelPrijs;
    private String Knuffelfoto;
    private String KnuffelBeschrijving;


    public Knuffel(int id, String KnuffelNaam, String KnuffelPrijs, String Knuffelfoto, String KnuffelBeschrijving) {
        this.id = id;
        this.KnuffelNaam = KnuffelNaam;
        this.KnuffelPrijs = KnuffelPrijs;
        this.Knuffelfoto = Knuffelfoto;
        this.KnuffelBeschrijving = KnuffelBeschrijving;
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

    public String getKnuffelfoto() {
        return Knuffelfoto;
    }

    public void setKnuffelfoto(String knuffelfoto) {
        Knuffelfoto = knuffelfoto;
    }

    public String getKnuffelBeschrijving() {
        return KnuffelBeschrijving;
    }

    public void setKnuffelBeschrijving(String knuffelBeschrijving) {
        KnuffelBeschrijving = knuffelBeschrijving;
    }
}
