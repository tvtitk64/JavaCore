package src.Training.Ex1;

public class Runtime {
    public static void main(String[] args) {
        CanBo canBo = new KySu("Toan", 18, "male", "Ha Noi", "IT");
        System.out.println(canBo.displayInformation());

        canBo.staticMethodDemo();
    }
}
