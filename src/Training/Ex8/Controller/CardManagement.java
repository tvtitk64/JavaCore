package src.Training.Ex8.Controller;


import src.Training.Ex8.Model.Card;
import src.Training.Ex8.Model.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CardManagement {
    List<Card> cardList = new ArrayList<>();

    public void addCard(Card card) {
        cardList.add(card);
    }

    public void deleteCard(String code) {
        Optional<Card> card = cardList.stream().filter(card1 -> card1.getCode().equals(code)).findFirst();
        if (card.isPresent()) {
            cardList.remove(card);
        }
    }

    public void displayCardInfo() {
        cardList.forEach(card -> {
            System.out.println("Ma cua the: " + card.getCode());
            System.out.println("Ngay muon sach: " + card.getDayBorrow());
            System.out.println("Ngay tra sach: " + card.getDayReturn());
            System.out.println("So hieu sach: " + card.getBookCode());
            System.out.println("Thong tin cua sinh vien: ");
            Students students = card.getStudents();
            System.out.println("Ten: " + students.getName());
            System.out.println("Tuoi: " + students.getAge());
            System.out.println("Lop: " + students.getMajor());
        });
    }
}
