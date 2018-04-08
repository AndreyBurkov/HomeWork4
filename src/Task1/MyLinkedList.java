package Task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements ILinkedList<T> {

    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
        }
    }

    private int size;
    private Node<T> first;
    private Node<T> last;

    public void add(T element) {
        if (size == 0) {
            last = first = new Node<T>(element);
        }
        else {
            last.next = new Node<T>(element);
            last = last.next;
        }
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index >= size) {
            System.out.println("Index error");
            return;
        }
        Node<T> newNode = new Node<>(element);
        Node<T> current = first;
        Node<T> prev = null;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = newNode;
        newNode.next = current;
        size++;
    }

    public void clear() {
        if (size == 0) return;
        Node<T> current = first;
        Node<T> currentNext = current.next;
       while (true) {
           current.next = null;
           current = currentNext;
           if (current == null) break;
           else currentNext = current.next;
       }
       first = last = null;
       size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.print(" Index error ");
            return null;
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public int indexOf(T element) {
        int index = -1;
        int count = 0;
        Node<T> current = first;
        while (current != null) {
            if (current.element.equals(element)) {
                index = count;
                break;
            }
            current = current.next;
            count++;
        }
        return index;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            System.out.print(" Index error ");
            return null;
        }
        Node<T> current = first;
        Node<T> prev = null;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        if (index == size - 1) last = prev;
        size--;
        return current.element;
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            System.out.print(" Index error ");
            return null;
        }
        Node<T> newNode = new Node<>(element);
        Node<T> prev  = null;
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        newNode.next = current.next;
        prev.next = newNode;
        if (index == size - 1) last = newNode;
        return current.element;
    }

    public int size() {
        return size;
    }

    public T[] toArray(T[] arr) {
        if (size == 0) return null;
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            arr[i] = current.element;
            current = current.next;
        }
        return arr;
    }

    public String toString() {
        if (size == 0) return "[ empty ]";
        String result = "[ ";
        Node<T> current = first;
        while (current != null) {
            result += current.element;
            current = current.next;
            if (current != null) result += ", ";
        }
        result += " ], SIZE = " + size;
        return result;
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = first;
            private boolean wasFirst = false;      // выводился ли первый элемент

            @Override
            public boolean hasNext() {
                return current.next == null ? false : true;
            }

            @Override
            public T next() throws NoSuchElementException {
                if (current == first && wasFirst == false) {
                    wasFirst = true;
                    return first.element;
                }
                current = current.next;
                if (current == null) throw new NoSuchElementException();
                return current.element;
            }
        };
    }
}
