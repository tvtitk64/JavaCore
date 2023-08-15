package src.Training.Ex5.Model;

public class RoomC extends Room {
    public RoomC() {
        super("C", 100);
    }

    @Override
    public String toString() {
        return "RoomC{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
