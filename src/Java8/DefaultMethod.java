package src.Java8;

interface Shape {
    double getArea();

    default void printArea() {
        System.out.println(getArea());
//        System.out.println("1");
    }
}

//interface Shape2 {
//    default void printArea() {
//        System.out.println("2");
//    }
//}

class Circle implements Shape{
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void printArea() {
        Shape.super.printArea();
    }
}

public class DefaultMethod {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.printArea();
    }
}

