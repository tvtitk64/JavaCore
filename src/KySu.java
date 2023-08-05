package src;

public class KySu extends CanBo{
    private String major;

    public KySu(String name, int age, String sex, String address, String major) {
        super(name, age, sex, address);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void displayInformation() {
        System.out.println("Cong nhan: " + getName() + ", " + getAge() + ", " + getSex() + ", " + getAddress() + ", " + getMajor());
    }
}