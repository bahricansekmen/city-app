package com.example.sehirtanitimi;

import java.io.Serializable;

public class Sehirsimgeleri implements Serializable {

    String name;
    String country;
    int image;

    public Sehirsimgeleri(String name, String country, int image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
