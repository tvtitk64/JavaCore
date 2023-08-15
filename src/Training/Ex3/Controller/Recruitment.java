package src.Training.Ex3.Controller;

import src.Training.Ex3.Model.University;

import java.util.ArrayList;
import java.util.List;

public class Recruitment {
    List<University> universityList = new ArrayList<>();

    public void add(University university) {
        this.universityList.add(university);
    }

    public void showInfor() {
        this.universityList.forEach(candidate -> System.out.println(candidate.toString()));
    }

    public University searchById(String id) {
        return this.universityList.stream().filter(candidate -> candidate.getNumber().equals(id)).findFirst().orElse(null);
    }

}
