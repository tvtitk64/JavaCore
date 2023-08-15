package src.Java8;

@FunctionalInterface // không bắt buộc nhưng nên có để phân biệt phòng khi có nhiều hơn 1 abstract method
public interface Flyable {
    void fly();

    default boolean alive() {
        return true;
    }
}
