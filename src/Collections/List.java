package src.Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class List {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//        Collections.sort(cars);
//        System.out.println(cars);
//
//        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
//        myNumbers.add(33);
//        myNumbers.add(15);
//        myNumbers.add(20);
//        myNumbers.add(34);
//        myNumbers.add(8);
//        myNumbers.add(12);
//
//        Collections.sort(myNumbers);
//        for (int i : myNumbers) {
//            System.out.println(i);
//        }


        LinkedList<String> list = new LinkedList<String>();
        // thêm các phần tử vào list
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add("Java");
        System.out.println("Cac phan tu trong list: ");
        //System.out.println(list);
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext())  {
//            System.out.println((String) iterator.next());
//        }
        LinkedList<String> listA = new LinkedList<String>();
        listA.addAll(list);
        System.out.println(listA);
        LinkedList<String> listB = new LinkedList<String>();
        listB.add("Java");
        listA.retainAll(listB);
        System.out.print("listA: " + listA);
        list.removeAll(listB);
        System.out.println("\nList: " + list);
        list.set(1, "Python");
        System.out.println("List: " + list);
        //list.clear();
        System.out.println(list.contains("Python"));
        System.out.println(list.contains("Java"));
    }
}
