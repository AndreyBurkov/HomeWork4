import Task1.*;
import Task2.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {

        MyLinkedList<Integer> lst = new MyLinkedList<>();
        lst.add(0);
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);
        lst.add(2, 22);
        lst.add(6, 156);

        System.out.println(lst);
        System.out.println("lst[5] = " + lst.get(5));
        System.out.println("indexOf(5) = " + lst.indexOf(5));
        System.out.println("remove(4) element: " + lst.remove(4));
        System.out.println(lst);
        System.out.println("set[7] = " + lst.set(7, 99) + " by 99: ");
        System.out.println(lst);
        Integer[] arr = new Integer[lst.size()];
        arr = lst.toArray(arr);
        System.out.print("toArray: ");
        for (Integer i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        Iterator<Integer> iter = lst.iterator();
        System.out.print("Using iterator: ");
        try {
            while (iter.hasNext()) {
                System.out.print(iter.next() + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        lst.clear();
        System.out.println("Clear: " + lst);

        /*
               Сравнение основных операций
               для своего MyLinkedList и java.util.LinkedList
         */
        long beginTime, endTime;
        LinkedList<Integer> lst2 = new LinkedList<>();
        int n = 100_000;
        Random rand = new Random();
        Integer someValue = Math.abs(rand.nextInt() % n);

        System.out.println("\nAdd operation...");
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            lst.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("MyLinkedList: " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            lst2.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("java.util.LinkedList: " + (endTime - beginTime));

        System.out.println("\nFind operation...");
        beginTime = System.nanoTime();
        lst.get(someValue);
        endTime = System.nanoTime();
        System.out.println("MyLinkedList: " + (endTime - beginTime));
        beginTime = System.nanoTime();
        lst2.get(someValue);
        endTime = System.nanoTime();
        System.out.println("java.util.LinkedList: " + (endTime - beginTime));

        System.out.println("\nRemove operation...");
        beginTime = System.nanoTime();
        lst.remove(someValue);
        endTime = System.nanoTime();
        System.out.println("MyLinkedList: " + (endTime - beginTime));
        beginTime = System.nanoTime();
        lst2.remove(someValue);
        endTime = System.nanoTime();
        System.out.println("java.util.LinkedList: " + (endTime - beginTime));

        /*
                Задание 2
         */
        CollectionTimeCompare.task2();
    }
}
