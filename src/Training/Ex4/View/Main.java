package src.Training.Ex4.View;

import src.Training.Ex4.Model.Family;
import src.Training.Ex4.Model.Person;
import src.Training.Ex4.Model.Town;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Town town = new Town();
        System.out.println("Enter n");
        int n = scanner.nextInt();
        for (int i = 0; i < n ; i++) {
            System.out.println("Nhap thong tin gia dinh thu " + (i + 1));
            scanner.nextLine();
            System.out.println("Dia chi nha: ");
            String address = scanner.nextLine();
            System.out.println("Nhap so thanh vien");
            int number = scanner.nextInt();
            List<Person> personList = new ArrayList<>();
            for (int j = 0; j < number; j++) {
                System.out.println("Nhap ten: ");
                String name = scanner.nextLine();
                System.out.println("Nhap tuoi: ");
                int age = scanner.nextInt();
                System.out.println("Nghe nghiep: ");
                String job = scanner.nextLine();
                System.out.println("CCCD: ");
                int idNumber = scanner.nextInt();
                personList.add(new Person(name, age, job, idNumber));
            }
            town.addFamily(new Family(personList, address));
        }
    }
}
