package src.Training.Ex1;

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
    public String displayInformation() {
        return super.displayInformation() + ", major " + major;
    }

    public static void staticMethodDemo() {
        System.out.println("Ky Su");
    }
}
