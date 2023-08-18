package src.Training.Ex12.Model;

public class Car extends Vehicles{
    private int seatNumber;
    private String engineType;

    public Car(String id, String manufacturer, int year, int price, String color, int seatNumber, String engineType) {
        super(id, manufacturer, year, price, color);
        this.seatNumber = seatNumber;
        this.engineType = engineType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineType='" + engineType + '\'' +
                ", id='" + id + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
