package src.Training.Ex7.Model;

public class Teacher {
    private String name;
    private int age;
    private String hometown;
    private String idNumber;
    private int salary;
    private int bonus;
    private int punish;
    private int realSalary;

    public Teacher(String name, int age, String hometown, String idNumber, int salary, int bonus, int punish, int realSalary) {
        this.name = name;
        this.age = age;
        this.hometown = hometown;
        this.idNumber = idNumber;
        this.salary = salary;
        this.bonus = bonus;
        this.punish = punish;
        this.realSalary = realSalary;
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

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getPunish() {
        return punish;
    }

    public void setPunish(int punish) {
        this.punish = punish;
    }

    public int getRealSalary() {
        return realSalary;
    }

    public void setRealSalary(int realSalary) {
        this.realSalary = realSalary;
    }
}
