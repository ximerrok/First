package com.example.first;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String title;
    private String description;
    private int price;
    private double rating;
    private String thumbnail;

    public Product(int id, String title, String description, int price, double rating, String thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
