package src.Training.Ex10.View;

import src.Training.Ex10.Model.Document;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuoi ky tu");
        String s = scanner.nextLine();
        Document document = new Document(s);
        System.out.println("So tu cua chuoi ky tu la: " + document.countWords());
        System.out.println("So luong ky tu A cua chuoi la: " + document.countCharacters());
        document.textNormalization();
        System.out.println("Chuoi da chuan hoa:" + document.getString());
    }
}
