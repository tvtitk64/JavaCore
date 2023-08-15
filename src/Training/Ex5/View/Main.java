package src.Training.Ex5.View;

import src.Training.Ex5.Model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        while (true) {
            System.out.println("Choose your option below: ");
            System.out.println("Enter 1: add new people");
            System.out.println("Enter 2: remove people");
            System.out.println("Enter 3: calculate rent");
            System.out.println("Enter 4: end program");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter idNumber: ");
                    scanner.nextLine();
                    String idNumber = scanner.nextLine();
                    System.out.println("enter a for room a");
                    System.out.println("enter b for room b");
                    System.out.println("enter c for room c");
                    String type = scanner.nextLine();
                    Room room = null;
                    switch (type) {
                        case "a":
                            room = new RoomA();
                            break;
                        case "b":
                            room = new RoomB();
                            break;
                        case "c":
                            room = new RoomC();
                            break;
                        default:
                            break;
                    }
                    System.out.println("Enter your days");
                    int days = scanner.nextInt();
                    Person person = new Person(name, age, idNumber, room, days);
                    break;
                }
                case "2": {
                    System.out.println("Enter the id you want to remove");
                    String idNumber = scanner.nextLine();
                    hotel.removePeople(idNumber);
                    break;
                }
                case "3": {
                    System.out.println("Enter the id you want to calculate");
                    String idNumber = scanner.nextLine();
                    System.out.println(hotel.rent(idNumber));
                    break;
                }
                case "4":
                    break;
                default:
                    System.out.println("wrong");
            }
        }
    }
}
