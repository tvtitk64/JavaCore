package src.Training.Ex5.Model;

public class RoomA extends Room {
    public RoomA() {
        super("A", 500);
    }

    @Override
    public String toString() {
        return "RoomA{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
