package com.company.car;

import com.company.car.Car;

import java.io.Serializable;

public class UniversalCar extends Car implements Serializable {
    public UniversalCar (String brand,
                         double fuelConsumption, double velocity,
                         int maxPassengers) {

        //this.carID = 10;
        this.brand = brand;

        this.price = (int) (Math.random() * (100 - 0)) + 0;
        this.fuelConsumption = fuelConsumption;
        this.velocity = velocity;

        this.maxPassengers = maxPassengers;
        this.doors = 5;
    }

    @Override
    public String toString() {
        return "UniversalCar{" +
                "brand='" + brand + '\'' +
                ", carID='" + carID + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", velocity=" + velocity +
                ", maxPassengers=" + maxPassengers +
                ", doors=" + doors +
                '}';
    }
}
