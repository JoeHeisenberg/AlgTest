package cn.blog.dataStru.LinnerStru;

import java.lang.reflect.Array;

public class ArrayQueueTest<T> {

    private static final int DEFAULT_SIZE = 12;
    private T[] array;
    private int count;

    ArrayQueueTest(Class<T> type) {
        this(type, DEFAULT_SIZE);
    }

    ArrayQueueTest(Class<T> type, int size) {
        this.array = (T[]) Array.newInstance(type, size);
        this.count = 0;
    }

    public void add(T element) {
        array[count++] = element;
    }

    public T peek() {
        return array[0];
    }

    public T move() {
        T first = array[0];
        for (int i = 0; i < size() - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size() - 1] = null;
        return first;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printPreOrder() {
        if (isEmpty()) {
            System.out.println("mmp kong!!");
        }

        for (T e : array
                ) {
            if (e != null)
                System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ArrayQueueTest test = new ArrayQueueTest(String.class, 15);
        test.add("hahha");
        test.add("xixix");
        test.add("lalal");

        test.printPreOrder();
        test.move();
        System.out.println(test.peek());



    }

}
