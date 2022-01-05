package com.example.androidtraining.ui.favorite.model;

public class Photograph {
    private String name;
    private String photographerName;
    private int image;

    public Photograph(String name, String photographerName, int image) {
        this.name = name;
        this.photographerName = photographerName;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotographerName() {
        return photographerName;
    }

    public void setPhotographerName(String photographerName) {
        this.photographerName = photographerName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
