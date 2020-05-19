package com.company.car;

import com.company.car.Car;

import java.io.Serializable;

public class SedanCar  extends Car implements Serializable {
    public SedanCar (String brand,
                     double fuelConsumption, double velocity) {
        this.brand = brand;

        this.price = (int) (Math.random() * (100 - 0)) + 0;
        this.fuelConsumption = fuelConsumption;
        this.velocity = velocity;

        this.maxPassengers = 5;
        this.doors = 4;
    }

    @Override
    public  String toString() {
        return "SedanCar{" +
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
