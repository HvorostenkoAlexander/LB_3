package com.company.car;

import java.io.Serializable;

public abstract class Car implements Serializable {
    protected String brand;
    protected transient int carID;

    protected double fuelConsumption;
    protected double price;
    protected double velocity;

    protected int maxPassengers;
    protected int doors;

   @Override
    public  String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", carID='" + carID + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", velocity=" + velocity +
                ", maxPassengers=" + maxPassengers +
                ", doors=" + doors +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
