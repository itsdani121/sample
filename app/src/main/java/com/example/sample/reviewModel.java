package com.example.sample;

public class reviewModel {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(int ratingBar) {
        this.ratingBar = ratingBar;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public reviewModel(String name, String date, String details, float ratingBar, int img) {
        Name = name;
        Date = date;
        this.details = details;
        this.ratingBar = ratingBar;
        this.img = img;
    }

    private String Name, Date, details;
    private float ratingBar;
    private int img;

}
