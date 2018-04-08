package Task2;

import java.util.*;

public class CollectionTimeCompare {
    public static void task2() {
        long beginTime, endTime;
        int n = 100_000;

        /*
              ArrayList and LinkedList
        */
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("\n\tArrayList vs. LinkedList:");
        //      add
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList.add(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList.add(): " + (endTime - beginTime));
        //      get
        beginTime = System.nanoTime();
        arrayList.get(n / 3);
        endTime = System.nanoTime();
        System.out.println(" ArrayList.get(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        linkedList.get(n / 3);
        endTime = System.nanoTime();
        System.out.println(" LinkedList.get(): " + (endTime - beginTime));
        //      remove
        beginTime = System.nanoTime();
        arrayList.remove(n / 2);
        endTime = System.nanoTime();
        System.out.println("ArrayList.remove(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        linkedList.remove(n / 2);
        endTime = System.nanoTime();
        System.out.println("LinkedList.remove(): " + (endTime - beginTime));
        /*
            Вывод: ArrayList удобнее использовать в случайх, когда приходиться
            часто обращаться по индексу и удалять элементы. LinkedList же
            отличается быстрым добавлением элементов (если точный размер ArrayList
            не известен изначально) и всё.
            P.S. Здесь не учитывается вставка элементов в середину.
         */

        /*
              HashSet, LinkedHashSet, TreeSet
        */
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        System.out.println("\n\tHashSet, LinkedHashSet, TreeSet:");
        //      add
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("HashSet.add(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedHashSet.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("linkedHashSet.add(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("treeSet.add(): " + (endTime - beginTime));
        //      contains
        beginTime = System.nanoTime();
        hashSet.contains(n / 2);
        endTime = System.nanoTime();
        System.out.println(" hashSet.contains(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        linkedHashSet.contains(n / 2);
        endTime = System.nanoTime();
        System.out.println(" linkedHashSet.contains(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        treeSet.contains(n / 2);
        endTime = System.nanoTime();
        System.out.println(" treeSet.contains(): " + (endTime - beginTime));
        //      remove
        beginTime = System.nanoTime();
        hashSet.remove(n / 2);
        endTime = System.nanoTime();
        System.out.println("hashSet.remove(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        linkedHashSet.remove(n / 2);
        endTime = System.nanoTime();
        System.out.println("linkedHashSet.remove(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        treeSet.remove(n / 2);
        endTime = System.nanoTime();
        System.out.println("treeSet.remove(): " + (endTime - beginTime));
        /*
             Вывод: по результатам данных операций LinkedHashSet быстрее
             остальных по операциям добавления, поиска и удаления.
             TreeSet удобнее использовать, только если элементы должны
             быть упорядочены (у TreeSet худшее время по всем трём параметрам)
         */

        /*
              HashMap, LinkedHashMap, TreeMap
        */
        System.out.println("\n\tHashMap, LinkedHashMap, TreeMap:");
        HashMap<Integer, Double> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Double> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Double> treeMap = new TreeMap<>();
        //      put
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashMap.put(i, i / 100.0);
        }
        endTime = System.nanoTime();
        System.out.println("hashMap.put(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedHashMap.put(i, i / 100.0);
        }
        endTime = System.nanoTime();
        System.out.println("linkedHashMap.put(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeMap.put(i, i / 100.0);
        }
        endTime = System.nanoTime();
        System.out.println("treeMap.put(): " + (endTime - beginTime));
        //      get
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashMap.get(i);
        }
        endTime = System.nanoTime();
        System.out.println(" hashMap.get(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedHashMap.get(i);
        }
        endTime = System.nanoTime();
        System.out.println(" linkedHashMap.get(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeMap.get(i);
        }
        endTime = System.nanoTime();
        System.out.println(" treeMap.get(): " + (endTime - beginTime));
        //      remove
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashMap.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("hashMap.remove(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedHashMap.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("linkedHashMap.remove(): " + (endTime - beginTime));
        beginTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeMap.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("treeMap.remove(): " + (endTime - beginTime));
        /*
            Вывод: по времени выполнения операций put, get, remove
            HashMap и LinkedHashMap практически одинаковы, за исключением
            удаления(remove). TreeMap выполняет все три операции дольше, но
            имеет полезные методы для работы с отсортированными данными в
            этом отображении.
            HashMap больше подходит для быстрых вставки, чтения и удаления.
         */
    }
}
