package com.company;

import com.company.car.Car;

import java.io.IOException;
import java.util.ArrayList;

public class Train extends Thread{

    CarBuilder carBuilder;
    ArrayList< Car > cars;
    String fileAddress;


    Train(CarBuilder carBuilder, ArrayList< Car > cars,
            String fileAddress )

    {

        this.carBuilder = carBuilder;
        this.cars = cars;
        this.fileAddress = fileAddress;
    }  @Override

    public void run()

    {

        try {
            carBuilder.SerializableCar( cars,  fileAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
