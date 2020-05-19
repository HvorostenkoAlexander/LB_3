package com.company;

import com.company.car.Car;

import java.io.*;
import java.util.ArrayList;


public class CarBuilder {


    public CarBuilder() {
    }

    synchronized  static void SerializableCar (ArrayList<Car> cars, String fileAddress) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileAddress))) {
            oos.writeObject(cars);
            System.out.println("Объекты сохранены в Файл!");

            for (int i = 0; i < 3; i++) {

                System.out.println(i);


                Thread.sleep(400);

            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }




    }





    synchronized static ArrayList<Car> DerializableCar ( String fileAddress) throws IOException {

        ArrayList<Car> newCars= new ArrayList<Car>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileAddress)))
        {
            newCars=((ArrayList<Car>)ois.readObject());
        }
        catch(ClassNotFoundException ex){

            System.out.println(ex.getMessage());
        }
        for(Car car : newCars)
            System.out.printf( car.toString() +"\n");

        return  newCars;
    }

}
