package com.example.demo.beans;

public class Laptop {

    private int laptopId;
    private String laptopName;
    private double cost;

    public Laptop() {
    }

    public Laptop(int laptopId, String laptopName, double cost) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.cost = cost;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}