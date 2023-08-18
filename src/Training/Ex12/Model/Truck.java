package src.Training.Ex12.Model;

public class Truck extends Vehicles {
    private int tonnage;

    public Truck(String id, String manufacturer, int year, int price, String color, int tonnage) {
        super(id, manufacturer, year, price, color);
        this.tonnage = tonnage;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id='" + id + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                "tonnage=" + tonnage +
                '}';
    }
}
