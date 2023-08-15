package src.Training.Ex4.Model;


import java.util.List;

public class Family {
    private List<Person> personList;
    private String address;

    public Family(List<Person> personList, String address) {
        this.personList = personList;
        this.address = address;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    @Override
    public String toString() {
        return "Family{" +
                "personList=" + personList +
                ", address='" + address + '\'' +
                '}';
    }
}
