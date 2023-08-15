package src.Training.Ex2.Model;

public class Newspaper extends Document{
    private int dayRelease;

    public Newspaper(String code, String publisher, int number, int dayRelease) {
        super(code, publisher, number);
        this.dayRelease = dayRelease;
    }

    public int getDayRelease() {
        return dayRelease;
    }

    public void setDayRelease(int dayRelease) {
        this.dayRelease = dayRelease;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "dayRelease='" + dayRelease + '\'' +
                ", code=" + code +
                ", publisher=" + publisher +
                ", number=" + number +
                '}';
    }
}
