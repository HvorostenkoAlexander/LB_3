package com.company;

import com.company.car.Car;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaxiStation {
    List<Car> carPool;
    String stationName;



    public TaxiStation(String stationName,List<Car> carPool ) throws IOException {

        this.stationName = stationName;

        this.carPool = carPool;
    }

    //        Посчитать стоимость автопарка.
     public void costTaxiStation(){
        double costStation = 0.0;

        for (Car car : carPool){
            costStation += car.getPrice();
        }
        System.out.println("Стоимость машин в парке: " + Math.round(costStation*100)/100.0 );

    }

    //        Провести сортировку автомобилей парка по расходу топлива.
    public void sortFuelConsumption(){
        Collections.sort(carPool, new Comparator<Car>() {

            @Override
            public int compare(Car car1, Car car2) {
                return ((int) Math.round(100.0 * (car1.getFuelConsumption() - car2.getFuelConsumption())));
            }
        });

        for (Car car: carPool) {
            System.out.printf("Потребление топлива  %s: %s",car.getFuelConsumption(), car );

            System.out.println();
        }
    }



    /*
        Найти автомобиль в компании, соответствующий
         заданному диапазону параметров скорости.
*/
    public void carSearch() throws CarException {

        try {
            Scanner in = new Scanner(System.in);
            System.out.println("\n Найдите автомобили отвечающие Вашим критериям скорости");
            System.out.println("Какой должна быть минимальная скорость автомобиля? ");
            double minVelocity = in.nextInt();

            System.out.println("Какое значение не должна превышать максимальная скорость автомобиля? ");
            double maxVelocity = in.nextInt();

            if (maxVelocity < minVelocity)
                throw new CarException("Указанное Вами значение меньше минимальной, \n" +
                        "укажите другое");

               // maxVelocity = in.nextInt();



            for (Car car : carPool) {
                if (car.getVelocity() >= minVelocity && car.getVelocity() <= maxVelocity) {
                    System.out.printf("Скорость %s: %s", car, car.getVelocity());
                    System.out.println();
                }


            }
        }
        catch (CarException ex){
            System.out.println(ex.getMessage());
        }

    }




    public List<Car> getCarPool() {
        return carPool;
    }

    public void setCarPool(List<Car> carPool) {
        this.carPool = carPool;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        stationName = stationName;
    }





}
