package src.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //consumer dùng vs list, stream để xử lí các phần tử bên trong
//        List<String> list = Arrays.asList("stack", "java", "stackjava.com");
//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) { //Phương thức chấp nhận một tham số đầu vào và không trả về gì cả.
//                System.out.println(s);
//            }
//        });
//        System.out.println("----------------");
//        list.forEach(s -> System.out.println(s));



        List<Integer> list2 = new ArrayList<>();
        list2.add(-1);
        list2.add(1);
        list2.add(0);
        list2.add(-2);
        list2.add(3);

        list2.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 0;
            }
        });

        list2.forEach(integer -> System.out.println(integer));
        System.out.println("----");
        list2.removeIf(integer -> integer > 1);
        list2.forEach(integer -> System.out.println(integer));


        List<String> list = Arrays.asList("stack", "JAVA", "demo", "Function");
        Stream<String> stream = list.stream();

        stream.map(new Function<String, String>() {
            @Override
            public String apply(String t) { //Method này nhận đầu vào là 1 tham số và trả về một giá trị.
                return t.toUpperCase();
            }
        }).forEach(t -> System.out.println(t));
        System.out.println("---------------");


        stream = list.stream();// lưu ý là stream ko thể dùng lại nên phải khởi tạo lại
        stream.map(t -> t.toLowerCase()).forEach(t -> System.out.println(t));

//        Random random = new Random();
//        Stream<Integer> stream = Stream.generate(new Supplier<Integer>() {
//            @Override
//            public Integer get() {  //// method này không có tham số nhưng trả về một kết quả.
//                return random.nextInt(10);
//            }
//        }).limit(5);
//
//        stream.forEach(t -> System.out.print(t +" "));
//
//        stream = Stream.generate(() -> random.nextInt(10)).limit(5);
//        stream.forEach(t -> System.out.print(t +" "));
    }
}
