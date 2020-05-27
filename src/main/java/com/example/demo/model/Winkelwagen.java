package com.example.demo.model;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class Winkelwagen {
    @OneToOne(fetch = FetchType.LAZY)
    private Knuffel knuffel;



    public Winkelwagen(){

    }
}
