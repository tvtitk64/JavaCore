package src.Training.Ex1;

public class CongNhan extends CanBo {
    private int rank;

    public static void main(String[] args) {
        CongNhan.showInfo();
    }

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
    public String displayInformation() {
         return super.displayInformation() + ", rank: " + rank;
    }
}
