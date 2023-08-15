package src.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
//        List<String> items = new ArrayList<String>();
//        items.add("one");
//        items.add("two");
//        items.add("three");
//        items.add("fore");
//        items.add("five");
//
//        Stream<String> stream = items.stream();
//        List<String> filtered = items.stream()
//                .filter(item -> item.startsWith("t"))
//                .collect(Collectors.toList());
//        System.out.println(filtered);
//
//        List<String> mapped = items.stream()
//                .map(item -> item.toUpperCase())
//                .collect(Collectors.toList());
//        System.out.println(mapped);
//
//        String reduced = items.stream()
//                .reduce((acc, item) -> acc + " " + item)
//                .get();
//        System.out.println(reduced);
//
//        long countNum = items.stream()
//                .filter(item -> item.startsWith("f"))
//                .count();
//        System.out.println(countNum);
        List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
        List<Integer> wordLengths =
                words.stream()
                        .map(String::length)
                        .collect(Collectors.toList());
        System.out.println(words);
        System.out.println(wordLengths);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        numbers.stream()
                .filter(t -> t > 4)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
