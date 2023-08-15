package src.Training.Ex2.View;

import src.Training.Ex2.Controller.BookManagement;
import src.Training.Ex2.Model.Book;
import src.Training.Ex2.Model.Document;
import src.Training.Ex2.Model.Magazine;
import src.Training.Ex2.Model.Newspaper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManagement bookManagement = new BookManagement();
        while (true) {
            System.out.println("Please choose the function below");
            System.out.println("Enter 1 to add new documents");
            System.out.println("Enter 2 to remove documents");
            System.out.println("Enter 3 to show documents's info");
            System.out.println("Enter 4 to search");
            System.out.println("Enter 5 to exit the program");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Choose kind of documents");
                    System.out.println("Press a to add book");
                    System.out.println("Press b to add magazine");
                    System.out.println("Press c to add newspaper");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.println("Enter code");
                            String code = scanner.nextLine();
                            System.out.println("Enter publisher");
                            String publisher = scanner.nextLine();
                            System.out.println("Enter number");
                            int number = scanner.nextInt();
                            System.out.println("Enter author");
                            String author = scanner.nextLine();
                            System.out.println("Enter page number");
                            int pageNumber = scanner.nextInt();
                            Document book = new Book(code, publisher, number, author, pageNumber);
                            bookManagement.addDocument(book);
                            System.out.println(book.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "b": {
                            System.out.println("Enter code");
                            String code = scanner.nextLine();
                            System.out.println("Enter publisher");
                            String publisher = scanner.nextLine();
                            System.out.println("Enter number");
                            int number = scanner.nextInt();
                            System.out.println("Enter issue number");
                            int issueNumber = scanner.nextInt();
                            System.out.println("Enter month release");
                            int monthRelease = scanner.nextInt();
                            Document magazine = new Magazine(code, publisher, number, issueNumber, monthRelease);
                            bookManagement.addDocument(magazine);
                            System.out.println(magazine.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "c": {
                            System.out.println("Enter code");
                            String code = scanner.nextLine();
                            System.out.println("Enter publisher");
                            String publisher = scanner.nextLine();
                            System.out.println("Enter number");
                            int number = scanner.nextInt();
                            System.out.println("Enter day release");
                            int dayRelease = scanner.nextInt();
                            Document newspaper = new Newspaper(code, publisher, number, dayRelease);
                            bookManagement.addDocument(newspaper);
                            System.out.println(newspaper.toString());
                            scanner.nextLine();
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Enter code to remove: ");
                    String code = scanner.nextLine();
                    bookManagement.deleteDocument(code);
                    break;
                case "3":
                    bookManagement.showInfo();
                    break;
                case "4":
                    System.out.println("Enter a to search book: ");
                    System.out.println("Enter b to search magazine: ");
                    System.out.println("Enter c to search newspaper: ");
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "a":
                            bookManagement.searchForBook();
                            break;
                        case "b":
                            bookManagement.searchForMagazine();
                            break;
                        case "c":
                            bookManagement.searchForNewspaper();
                            break;
                        default:
                            break;
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("nothing");
            }
        }
    }
}
