package com.company;


/*ЛБ_3
        Создать консольное приложение, удовлетворяющее следующим требованиям:
        •	 Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
        •	 Каждый класс должен иметь отражающее смысл название и информативный состав.
        •	 Наследование должно применяться только тогда, когда это имеет смысл.
        •	 При кодировании должны быть использованы соглашения об оформлении кода java code convention.
        •	 Классы должны быть грамотно разложены по пакетам.
        •	 Консольное меню должно быть минимальным.
        •	 Для хранения параметров инициализации можно использовать файлы.
        28.	 Таксопарк. Определить иерархию легковых автомобилей. Создать таксо¬парк.
        Подсчитать стоимость автопарка. Провести сортировку автомобилей парка по расходу топлива.
        Найти автомобиль в компании, соответствую¬щий заданному диапазону параметров скорости.*/


/*
ЛБ_4
        1.	Выполнить задания из варианта B Лабораторная работа №3,
        сохраняя объекты приложения в од¬ном или нескольких файлах с применением механизма сериализации.
        Объекты могут содержать поля, помеченные как static, а также transient.
        Для изменения информации и извлечения информации в файле создать специальный
        класс- коннектор с необходимыми для выполнения этих задач методами.
        2.	Выполнить задания из варианта В Лабораторная работа №3,
        реализуя собственные обработчики исключений и исключения ввода/вывода.
        3.	Для заданий варианта В Лабораторная работа №3 организовать синхронизированный доступ к ре¬сурсам (файлам).
        Для каждого процесса создать отдельный поток выполнения.
*/


import com.company.car.Car;
import com.company.car.SedanCar;
import com.company.car.UniversalCar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, CarException {


        String filename = "cars.out";
        // создадим список объектов, которые будем записывать в файл
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new UniversalCar("BMW", 30, 190, 5));
        cars.add(new UniversalCar("ford", 20, 170, 6));
        cars.add(new SedanCar("Fiat", 25, 180));
        cars.add(new SedanCar("Nissan", 35, 200));




        TaxiStation taxiStation_1 = new TaxiStation("Таксопарк_1",cars);


        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s ="";

        while (!"4".equals(s) ){

            System.out.println("1 - Подсчитать стоимость автопарка");
            System.out.println("2 - Провести сортировку автомобилей парка по расходу топлива");
            System.out.println("3 - Найти автомобиль в компании, соответствую¬щий заданному диапазону параметров скорости");
            System.out.println("4 - Для выхода из приложения ");
            s = scan.nextLine();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
            }

            switch (x){
                case 1:

                    taxiStation_1.costTaxiStation();
                    break;
                case 2:
                    taxiStation_1.sortFuelConsumption();
                    break;
                case 3:
                    taxiStation_1.carSearch();
                    break;

            }

        }


        //ЛБ_4
        //сериализация и дериализация
        CarBuilder.SerializableCar(cars, "cars.out");
        CarBuilder.DerializableCar("cars.out");

        //ЛБ_4
       /* Для заданий варианта В Лабораторная работа №3 организовать синхронизированный доступ к ре¬сурсам (файлам).
                Для каждого процесса создать отдельный поток выполнения.*/

        CarBuilder carBuilder = new CarBuilder();
        Train train1 = new Train(carBuilder, cars, "cars.out" );
        Train train2 = new Train(carBuilder, cars, "cars.out" );



        // оба потока начинают выполняться.

         train1.start();
        train2.start();






    }
}
