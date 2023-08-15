package src.Training.Ex2.Controller;

import src.Training.Ex2.Model.Book;
import src.Training.Ex2.Model.Document;
import src.Training.Ex2.Model.Magazine;
import src.Training.Ex2.Model.Newspaper;

import java.util.*;

public class BookManagement {
    Set<Document> documentList = new HashSet<>();

    public void addDocument(Document document) {
        documentList.add(document);
    }

    public void deleteDocument(String code) {
        Document document = this.documentList.stream()
                .filter(documentList -> documentList.getCode().equals(code))
                .findFirst().orElse(null);
        documentList.remove(document);
    }

    public void showInfo() {
        documentList.forEach(document -> System.out.println(document.toString()));
    }


    public void searchForBook() {
        documentList.stream().filter(document -> document instanceof Book)
                .forEach(document -> System.out.println(document.toString()));
    }

    public void searchForNewspaper() {
        documentList.stream().filter(document -> document instanceof Newspaper)
                .forEach(document -> System.out.println(document.toString()));
    }

    public void searchForMagazine() {
        documentList.stream().filter(document -> document instanceof Magazine)
                .forEach(document -> System.out.println(document.toString()));
    }
}
