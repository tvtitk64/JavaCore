//package src.Java8;
//
//import java.util.Optional;
//
//class Student1 {
//    String name;
//}
//
//public class OptionalTest {
//    public void preJava8() {
//        Student1 student1 = getStudent();
//        if (student != null) {
//            System.out.println(student.name);
//        }
//    }
//
//    public void java8() {
//        Student1 student1 = getStudent();
//        Optional<Student1> opt = Optional.of(student1);
//        if (opt.isPresent()) {
//            System.out.println(opt.get().name);
//        }
//        // opt.ifPresent(s -> System.out.println(s.name));
//    }
//
//    private Student getStudent() {
//        Student1 student1 = new Student1();
//        student1.name = "gpcoder.com";
//        return null;
//    }
//}