package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        DataManager dataManager = new DataManager();
        ArrayList<Car> carArrayList;
        carArrayList = dataManager.loadData();
        Scanner scanner = new Scanner(System.in);
        boolean goOn = true;
        while (goOn){
            //main loop
            //for (int i = 0; i < 50; ++i) System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Add new car");
            System.out.println("2. List cars");
            System.out.println("3. Add Service");
            System.out.println("4. Print All Services");
            System.out.println("5. Save and quit");
            int option = 0;
            try{
                option = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException i){
                System.out.println("pleas enter valid choice");
            }
            switch (option){
                case 1:
                    carArrayList.add(dataManager.newCar());
                    System.out.println("Car added \nPress enter to continue");
                    scanner.nextLine();
                    break;
                case 2:
                    dataManager.listCars(carArrayList);
                    System.out.println("Press enter to continue");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("select car");
                    dataManager.listCars(carArrayList);
                    int car = Integer.parseInt(scanner.nextLine());
                    carArrayList.set(car, dataManager.newService(carArrayList.get(car)) ) ;
                    System.out.println("Press enter to continue");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("select car");
                    dataManager.listCars(carArrayList);
                    int car1 = Integer.parseInt(scanner.nextLine());
                    dataManager.listService(carArrayList.get(car1));
                    System.out.println("Press enter to continue");
                    scanner.nextLine();
                    break;
                case 5:
                    dataManager.saveData(carArrayList);
                    System.out.println("Done good bye Press enter to continue");
                    scanner.nextLine();
                    goOn = false;
                    break;

            }

        }
    }


}
