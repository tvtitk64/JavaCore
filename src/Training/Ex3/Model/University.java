package src.Training.Ex3.Model;

public class University {
    protected String number;
    protected String name;
    protected String address;
    protected int priority;

    public University(String number, String name, String address, int priority) {
        this.number = number;
        this.name = name;
        this.address = address;
        this.priority = priority;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
