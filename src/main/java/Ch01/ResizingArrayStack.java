package Ch01;

import java.util.Iterator;

/**
 * 下压栈实现（能够动态调整数组大小的实现）
 * Created by lph on 2018/1/26.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //重新定义数组大小，并将栈中元素移动到大小为max的数组中
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < items.length; i++)
            temp[i] = items[i];
        items = temp;
    }
    //添加元素到栈顶
    public void push(Item item) {
        if (N == items.length) {
            resize(2 * items.length);
        }
        items[N++] = item;
    }
    //删除栈顶元素
    public Item pop() {
        Item item = items[--N];
        items[N] = null;
        if (N > 0 && N == items.length / 2) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    //实现支持后进先出的迭代器
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return items[--i];
        }

        @Override
        public void remove() {

        }
    }
}
