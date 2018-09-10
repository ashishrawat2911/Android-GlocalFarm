package com.glocalfarm.models;

public class Vegetable {
    private String name;
    private int image;

    public Vegetable(String name, int imageUrl) {
        this.name = name;
        this.image = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
