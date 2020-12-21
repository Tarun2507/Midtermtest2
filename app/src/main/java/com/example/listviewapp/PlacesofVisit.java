package com.example.listviewapp;

public class PlacesofVisit {

    private String country;
    private String name;
    private String imgName;
    private int price;

    public PlacesofVisit(String country, String name, String imgName, int price) {
        this.country = country;
        this.name = name;
        this.imgName = imgName;
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
