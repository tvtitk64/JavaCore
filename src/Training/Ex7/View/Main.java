package src.Training.Ex7.View;

import src.Training.Ex6.Controller.StudentManagement;
import src.Training.Ex6.Model.Student;
import src.Training.Ex7.Controller.TeacherManagement;
import src.Training.Ex7.Model.Teacher;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TeacherManagement teacherManagement = new TeacherManagement();
        while (true) {
            System.out.println("Choose your option below: ");
            System.out.println("Enter 1: add teacher");
            System.out.println("Enter 2: remove teacher");
            System.out.println("Enter 3: calculate teacher's salary");
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
                    System.out.println("Enter id number");
                    String idNumber = scanner.nextLine();
                    System.out.println("Enter salary");
                    int salary = scanner.nextInt();
                    System.out.println("Enter bonus");
                    int bonus = scanner.nextInt();
                    System.out.println("Enter punish");
                    int punish = scanner.nextInt();
                    System.out.println("Enter real salary");
                    int realSalary = scanner.nextInt();
                    Teacher teacher = new Teacher(name, age, hometown, idNumber, salary, bonus, punish, realSalary);
                    teacherManagement.addTeacher(teacher);
                    break;
                }
                case "2": {
                    System.out.println("Enter the id of teacher you want to remove: ");
                    String idNumber = scanner.nextLine();
                    teacherManagement.deleleTeacher(idNumber);
                }
                case "3": {
                    System.out.println("Enter the id of the teacher you want to calculate the salary: ");
                    String idNumber = scanner.nextLine();
                    System.out.println("Her salary is: " + teacherManagement.paySalary(idNumber));
                    break;
                }
                default:
                    System.out.println("wrong option");
            }
        }
    }
}
