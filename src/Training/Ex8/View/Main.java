package src.Training.Ex8.View;

import src.Training.Ex7.Model.Teacher;
import src.Training.Ex8.Controller.CardManagement;
import src.Training.Ex8.Model.Card;
import src.Training.Ex8.Model.Students;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardManagement cardManagement = new CardManagement();
        while (true) {
            System.out.println("Choose your option below: ");
            System.out.println("Enter 1: add card");
            System.out.println("Enter 2: remove card");
            System.out.println("Enter 3: display card's information");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    System.out.print("Enter code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter day borrow: ");
                    int dayBorrow = scanner.nextInt();
                    System.out.print("Enter day return: ");
                    scanner.nextLine();
                    int dayReturn = scanner.nextInt();
                    System.out.println("Enter book code");
                    int bookCode = scanner.nextInt();
                    System.out.println("Enter student's infomation");
                    scanner.nextLine();
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter age:");
                    int age = scanner.nextInt();
                    System.out.println("Enter major");
                    scanner.nextLine();
                    String major = scanner.nextLine();
                    Students students = new Students(name, age, major);
                    Card card = new Card(code, dayBorrow, dayReturn, bookCode, students);
                    cardManagement.addCard(card);
                    break;
                }
                case "2": {
                    System.out.println("Enter the id of card you want to remove: ");
                    String code = scanner.nextLine();
                    cardManagement.deleteCard(code);
                    break;
                }
                case "3": {
                    System.out.println("Card's information: ");
                    cardManagement.displayCardInfo();
                    break;
                }
                default:
                    System.out.println("wrong option");
            }
        }
    }
}
