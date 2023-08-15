package src.Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Hash {
    public static void main(String[] args) {
        Map<Integer, Integer> checkNumber = new HashMap<>();
//        Map<Integer, Integer> countNumber = new HashMap<>();
//        Map<Integer, Integer> checkEachNumber = new HashMap<>();
//        List<Integer> arrayA = new ArrayList<>();
//        List<Integer> arrayC = new ArrayList<>();
//
//
//        int n = 20;
//        for (int i = 0; i < n; i++) {
//            int random = (int)(Math.random() * 20);
//            arrayA.add(random);
//            checkNumber.put(random, random);
//        }
//        System.out.println("Mang A la:\n" + arrayA);
//        Collection<Integer> values = checkNumber.values();
//        List<Integer> arrayB = new ArrayList<Integer>(values);
//        System.out.println("Mang B la:\n" + arrayB);
//
//        for (int i = 0; i < arrayA.size(); i++) {
//            int temp = arrayA.get(i);
//            int count = 0;
//            for (int j = 0; j < arrayA.size(); j++) {
//                if (arrayA.get(j).equals(temp)) {
//                    count++;
//                    countNumber.put(temp, count);
//                }
//            }
//        }
//        for (Map.Entry<Integer, Integer> entrySet : countNumber.entrySet()) {
//            System.out.println("So lan xuat hien cua " + entrySet.getKey() + " la: "  + entrySet.getValue());
//        }
//
//        int m = 10;
//        for (int i = 0; i < m; i++) {
//            int random = (int)((Math.random() * 21) + 10);
//            arrayC.add(random);
//        }
//        System.out.println("Mang C:\n" + arrayC);
//
//        for (int i = 0; i < arrayC.size(); i++) {
//            for (int j = 0; j < arrayA.size(); j++) {
//                if (arrayC.get(i).equals(arrayA.get(j))) {
//                    checkEachNumber.put(arrayC.get(i), 1);
//                    break;
//                }
//                checkEachNumber.put(arrayC.get(i), 0);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entrySetCheck : checkEachNumber.entrySet()) {
//            if (entrySetCheck.getValue() == 1) {
//                System.out.println("Phan tu " + entrySetCheck.getKey() + " xuat hien trong day A ");
//            } else {
//                System.out.println("Phan tu " + entrySetCheck.getKey() + " khong xuat hien trong day A ");
//            }
//
//        }

        //vi du ve hashset
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("John");
        hashSet.add("Smith");
        hashSet.add("Peter");
        System.out.println(hashSet);
        hashSet.remove("Peter");
        System.out.println(hashSet);
        System.out.println(hashSet.size());
        hashSet.clear();
        System.out.println(hashSet);
    }
}
