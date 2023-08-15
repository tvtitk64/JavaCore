package src.Java8;

import java.util.Arrays;
import java.util.List;

public class Lambda {
    //predicate
//    public static void main(String[] args) {
//
//        Predicate<String> predicate = s -> {
//            return s.equals("gpcoder");
//        };
//        Predicate<String> predicateAnd = predicate.and(s -> s.length() == 11);
//        System.out.println(predicateAnd.test("gpcoder"));
//
//        Predicate<String> predicateOr = predicate.or(s -> s.length() == 11);
//        System.out.println(predicateOr.test("gpcoder"));
//
//        Predicate<String> predicateNegate= predicate.negate();
//        System.out.println(predicateNegate.test("gpcoder"));
//    }
//    Predicate<String> somePredicate = new Predicate<String>() {
//        @Override
//        public boolean test(String s) {
//            return !s.isEmpty();
//        }
//    };


//    Predicate<String> predicateString = s -> {
//        return s.equals("gpcoder");
//    };
//        System.out.println(predicateString.test("gpcoder")); // true
//        System.out.println(predicateString.test("GP Coder")); // false
//
//    // Predicate integer
//    Predicate<Integer> predicateInt = i -> {
//        return i > 0;
//    };
//        System.out.println(predicateInt.test(1)); // true
//        System.out.println(predicateInt.test(-1)); // false

    //consumer
    public static void main(String[] args) {
//        String x = "JavaString";
//
//        Consumer<String> myConsumer = (y) ->
//        {
//            System.out.println("x = " + x.toLowerCase());
//            System.out.println("y = " + y.toUpperCase());
//        };
//
//        myConsumer.accept(x);
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        numbers.add(5);
//        numbers.add(9);
//        numbers.add(8);
//        numbers.add(1);
//        Collections.sort(numbers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        numbers.forEach( (n) -> {
//            System.out.println(n);
//        } );

        //method reference
        List<String> myList = Arrays.asList("INDIA", "AUSTRALIA","ENGLAND", "NEWZEALAND", "SCOTLAND");
        System.out.println("----------Lambda Expression---------");
        myList.stream().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        System.out.println("----------Method reference---------");
        myList.stream().map(String :: toUpperCase)//.sorted()
                .forEach(System.out :: println);

        //object::instanceMethod -> ví dụ: System.out::println
        //Class::staticMethod -> ví dụ: Math::max
        //Class::instanceMethod -> ví dụ String::length
    }
}
