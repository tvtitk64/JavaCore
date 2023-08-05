package src;

public class CongNhan extends CanBo {
    private int rank;

    public CongNhan(String name, int age, String sex, String address, int rank) {
        super(name, age, sex, address);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public void displayInformation() {
        System.out.println("Cong nhan: " + getName() + ", " + getAge() + ", " + getSex() + ", " + getAddress() + ", " + getRank());
    }
}
