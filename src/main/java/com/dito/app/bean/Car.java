package com.dito.app.bean;

/**
 * Created by dell on 12/12/2017.
 */

public class Car {
    private String id;
    private int year;
    private String brand;
    private String color;

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public Car(String id, int year, String brand, String color){
        this.id = id;
        this.year = year;
        this.brand = brand;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
