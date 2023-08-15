package src.Training.Ex9.View;

import src.Training.Ex8.Controller.CardManagement;
import src.Training.Ex8.Model.Card;
import src.Training.Ex8.Model.Students;
import src.Training.Ex9.Controller.CustomerManagement;
import src.Training.Ex9.Model.Customer;
import src.Training.Ex9.Model.Receipt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManagement customerManagement = new CustomerManagement();
        while (true) {
            System.out.println("Choose your option below: ");
            System.out.println("Enter 1: add new customer");
            System.out.println("Enter 2: remove customer");
            System.out.println("Enter 3: calculate bill");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter home address: ");
                    int homeAddress = scanner.nextInt();
                    System.out.print("Enter code: ");
                    scanner.nextLine();
                    String code = scanner.nextLine();
                    Customer customer = new Customer(name, homeAddress, code);
                    System.out.println("Enter customer's receipt :");
                    scanner.nextLine();
                    System.out.println("Enter oldIndex: ");
                    int oldIndex = scanner.nextInt();
                    System.out.println("Enter oldIndex: ");
                    int newIndex = scanner.nextInt();
                    System.out.println("Enter bill: ");
                    int bill = scanner.nextInt();
                    Receipt receipt = new Receipt(customer, oldIndex, newIndex, bill);
                    customerManagement.addReceipt(receipt);
                    break;
                }
                case "2": {
                    System.out.println("Enter the id of customer you want to remove: ");
                    String code = scanner.nextLine();
                    customerManagement.removeCustomer(code);
                    break;
                }
                case "3": {
                    System.out.println("Enter the id of customer you want to calculate the bill: ");
                    String code = scanner.nextLine();
                    System.out.println(customerManagement.calculateBill(code));
                    break;
                }
                default:
                    System.out.println("wrong option");
            }
        }
    }
}
