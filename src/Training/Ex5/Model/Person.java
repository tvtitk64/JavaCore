package src.Training.Ex5.Model;

public class Person {
    private String name;
    private int age;
    private String idNumber;

    private Room room;

    private int days;


    public Person(String name, int age, String idNumber, Room room, int days) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
        this.room = room;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idNumber='" + idNumber + '\'' +
                ", room=" + room.toString() +
                '}';
    }
}
