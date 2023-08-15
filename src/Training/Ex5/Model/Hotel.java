package src.Training.Ex5.Model;

import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    private Set<Person> personList = new HashSet<>();

    public void addPeople(Person person) {
        personList.add(person);
    }

    public void removePeople(String idNumber) {
        Optional<Person> person = personList.stream()
                .filter(person1 -> person1.getIdNumber().equals(idNumber))
                .findFirst();
        if (person.isPresent()) {
            personList.remove(person.get());
        }
    }

    public int rent(String idNumber) {
        Person person = personList.stream()
                .filter(person1 -> person1.getIdNumber().equals(idNumber))
                .findFirst().get();
        if (person != null) {
            return person.getRoom().getPrice() * person.getDays();
        } else {
            return 0;
        }
    }

}
