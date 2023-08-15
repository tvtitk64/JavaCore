package src.Training.Ex1;

public abstract class CanBo {
    protected String name;
    protected int age;
    protected String sex;
    protected String address;

    public CanBo(String name, int age, String sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public CanBo(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void showInfo() {
        System.out.println("Java Core OOP");
    };

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String displayInformation() {
        return "name: " + name + ", age: " + age + ", sex: " +  sex + ", address: " + address;
    }

    public static void staticMethodDemo() {
        System.out.println("CanBO");
    }
}
