package src.Training.Ex13.View;

import src.Training.Ex12.Controller.VehicleManagement;
import src.Training.Ex12.Model.Bike;
import src.Training.Ex12.Model.Car;
import src.Training.Ex12.Model.Truck;
import src.Training.Ex12.Model.Vehicles;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleManagement vehicleManagement = new VehicleManagement();
        while (true) {
            System.out.println("Choose your option: ");
            System.out.println("Enter 1: To add new vehicles");
            System.out.println("Enter 2: To remove vehicles by id: ");
            System.out.println("Enter 3: To search for vehicles by manufacturer and color");
            System.out.println("Enter 4: To exit the program:");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("Enter a: to insert Bike");
                    System.out.println("Enter b: to insert Car");
                    System.out.println("Enter c: to insert Truck");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.print("Enter id: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter manufacturer:");
                            String manufacturer = scanner.nextLine();
                            System.out.print("Enter year: ");
                            int year = scanner.nextInt();
                            System.out.print("Enter price: ");
                            int price= scanner.nextInt();
                            System.out.print("Enter color: ");
                            String color = scanner.nextLine();
                            scanner.nextLine();
                            System.out.print("Enter power: ");
                            int power = scanner.nextInt();
                            Vehicles vehicles = new Bike(id, manufacturer, year, price, color, power);
                            vehicleManagement.addVehicles(vehicles);
                            System.out.println(vehicles.toString());
                            break;

                        }
                        case "b": {
                            System.out.print("Enter id: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter manufacturer:");
                            String manufacturer = scanner.nextLine();
                            System.out.print("Enter year: ");
//                            scanner.nextLine();
                            int year = scanner.nextInt();
                            System.out.print("Enter price: ");
                            int price= scanner.nextInt();
                            System.out.print("Enter color: ");
                            String color = scanner.nextLine();
                            System.out.print("Enter seatNumber: ");
                            int seatNumber = scanner.nextInt();
                            System.out.print("Enter engine type: ");
                            String engineType = scanner.nextLine();
                            Vehicles vehicles = new Car(id, manufacturer, year, price, color, seatNumber, engineType);
                            vehicleManagement.addVehicles(vehicles);
                            System.out.println(vehicles.toString());
                            break;
                        }
                        case "c": {
                            System.out.print("Enter id: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter manufacturer:");
                            String manufacturer = scanner.nextLine();
                            System.out.print("Enter year: ");
//                            scanner.nextLine();
                            int year = scanner.nextInt();
                            System.out.print("Enter price: ");
                            int price= scanner.nextInt();
                            System.out.print("Enter color: ");
                            String color = scanner.nextLine();
                            System.out.print("Enter tonnage: ");
                            int tonnage = scanner.nextInt();
                            Vehicles vehicles = new Truck(id, manufacturer, year, price, color, tonnage);
                            vehicleManagement.addVehicles(vehicles);
                            System.out.println(vehicles.toString());
                            break;
                        }
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                }
                case "2": {
                    System.out.print("Enter id to want remove: ");
                    String id = scanner.nextLine();
                    vehicleManagement.deleteVehicles(id);
                    break;
                }
                case "3": {
                    System.out.print("Enter manufacturer and color to search: ");
                    String manufacturer = scanner.nextLine();
                    String color = scanner.nextLine();
                    List<Vehicles> vehiclesList = vehicleManagement.searchForManufacturerAndColor(manufacturer, color);
                    vehiclesList.forEach(vehicles -> {
                        System.out.println(vehicles.toString());
                    });
                    break;
                }
                case "4": {
                    return;
                }
                default:
                    System.out.println("Invalid");
                    break;
            }

        }
    }
}
