package src.Training.Ex5.Model;

public class RoomB extends Room {
    public RoomB() {
        super("B", 300);
    }

    @Override
    public String toString() {
        return "RoomB{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
