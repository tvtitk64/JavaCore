package src;

public class NhanVien extends CanBo {
    private String job;

    public NhanVien(String name, int age, String sex, String address, String job) {
        super(name, age, sex, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void displayInformation() {
        System.out.println("Nhan vien: " + getName() + ", " + getAge() + ", " + getSex() + ", " + getAddress() + ", " + getJob());
    }

}