package src.Training.Ex4.Model;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private List<Family> familyList = new ArrayList<>();


    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }

    public void addFamily(Family family) {
        familyList.add(family);
    }

    public void showInfoFamily() {
        for (Family family : familyList) {
            System.out.println("So nha: " + family.getAddress());
            System.out.println("Danh sach thanh vien trong gia dinh: ");
            List<Person> personList = family.getPersonList();
            for (Person person : personList) {
                System.out.println("Ho ten: " + person.getName());
                System.out.println("Tuoi: " + person.getAge());
                System.out.println("nghe nghiep: " + person.getJob());
                System.out.println("CCCD: " + person.getIdNumber());
                System.out.println("----");
            }
            System.out.println("----");
        }
    }

    @Override
    public String toString() {
        return "Town{" +
                "familyList=" + familyList +
                '}';
    }
}
