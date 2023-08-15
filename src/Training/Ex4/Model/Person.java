package src.Training.Ex4.Model;

public class Person {
    private String name;
    private int age;
    private String job;
    private int idNumber;

    public Person(String name, int age, String job, int idNumber) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.idNumber = idNumber;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }
}
