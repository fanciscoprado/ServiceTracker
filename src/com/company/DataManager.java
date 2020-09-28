package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
    public ArrayList loadData() throws FileNotFoundException {
        ArrayList<Car> list = new ArrayList<Car>();
        //add loading function here
        try {
            FileInputStream fis = new FileInputStream("employee.ser");
            System.out.println("h");
            try (ObjectInputStream input = new ObjectInputStream(fis)) {
                list = (ArrayList<Car>) input.readObject();
            } catch (Exception e) {
                System.out.println("Error loading Data");
            }
        }catch (FileNotFoundException n){
            System.out.println("No previous data found");
        }



        return list;
    }
    public void saveData(ArrayList<Car> list){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

                out.writeObject(list);

            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public Car newCar(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.println(" ");
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.println(" ");
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println(" ");
        System.out.print("VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.println(" ");
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        System.out.println(" ");
        System.out.print("Phone number: ");
        String number = scanner.nextLine();
        System.out.println(" ");
        Car newCar = new Car(make, model, name, number, year, vin);
        return newCar;
    }
    public Car newService(Car temp){
        boolean oil= false, air= false, fuel= false, breakPads= false, cabin = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("current mileage?");
        int miles = Integer.parseInt(scanner.nextLine());
        System.out.println("Type Y or N for each question");
        System.out.println("Oil change?");
        if (scanner.nextLine().equals("Y"))
            oil = true;
        System.out.println("Replaced Air Filter?");
        if (scanner.nextLine().equals("Y"))
            air = true;
        System.out.println("Replaced fuel filter?");
        if (scanner.nextLine().equals("Y"))
            fuel = true;
        System.out.println("Replaced cabin air filter");
        if (scanner.nextLine().equals("Y"))
            cabin = true;
        System.out.println("replaced break pads?");
        if (scanner.nextLine().equals("Y"))
            breakPads = true;
        temp.setServiceDoneArrayList(new ServiceDone(miles, oil, air, fuel, cabin, breakPads));
        return temp;
    }
    public void listCars(ArrayList<Car> carList){
        int i = 0;
        for (Car temp : carList) {
            System.out.println(i + ") " + temp.getMake());
            i++;
        }

    }
    public  void listService(Car temp){
        for(ServiceDone tmp : temp.getServiceDoneArrayList()){
            System.out.println("Services done at: " + tmp.getMiles());
            if(tmp.isOil())
                System.out.println("Oil and Filter changed");
            if(tmp.isAirFilter())
                System.out.println("Air Filter Changed");
            if(tmp.isCabinAir())
                System.out.println("Cabin Air Filter Changed");
            if(tmp.isFuelFilter())
                System.out.println("Fuel Filter Changed");
            if(tmp.isBreakPads())
                System.out.println("Brake Pads Changed");
            System.out.println("------------------------------------------------------------");
        }

    }
}
