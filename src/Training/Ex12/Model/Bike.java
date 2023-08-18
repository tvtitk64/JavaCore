package src.Training.Ex12.Model;

public class Bike extends Vehicles{
    private int power;

    public Bike(String id, String manufacturer, int year, int price, String color, int power) {
        super(id, manufacturer, year, price, color);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "power=" + power +
                ", id='" + id + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
