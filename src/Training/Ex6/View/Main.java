package src.Training.Ex6.View;

import src.Training.Ex5.Model.*;
import src.Training.Ex6.Controller.StudentManagement;
import src.Training.Ex6.Model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        while (true) {
            System.out.println("Choose your option below: ");
            System.out.println("Enter 1: add student");
            System.out.println("Enter 2: display 20-year-old students");
            System.out.println("Enter 3: count the number of students with the age of 23 and hometown in DN");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter hometown: ");
                    scanner.nextLine();
                    String hometown = scanner.nextLine();
                    Student student = new Student(name, age, hometown);
                    studentManagement.addStudent(student);
                    break;
                }
                case "2": {
                    System.out.println("Here is the infomation of all 20-year-old students: ");
                    List<Student> list = studentManagement.get20YearOldStudent();
                    for (Student student : list) {
                        System.out.println("Ten cua hs: " + student.getName());
                        System.out.println("Tuoi cua hs: " + student.getAge());
                        System.out.println("Que quan cua hs: " + student.getHometown());
                    }
                }
                case "3": {
                    System.out.println("The number of students is: " + studentManagement.get23YearOldDNStudent());;
                    break;
                }
                default:
                    System.out.println("wrong option");
            }
        }
    }
}
