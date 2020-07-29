package lesson3.HW;

import java.util.EmptyStackException;

public class MyDeck<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 1;

    public MyDeck(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeck() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }


    public void insertLeft(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[begin] = item;
        begin = previousIndex(begin);
    }

    public void insertRigth(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T removeLeft() {
        T value = peekLeft();
        size--;
        list[nextIndex(begin)] = null;
        begin = nextIndex(begin);
        return value;
    }

    public T removeRigth() {
        T value = peekRigth();
        size--;
        list[end] = null;
        end = previousIndex(end);
        return value;
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[nextIndex(begin)];
    }

    public T peekRigth() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[previousIndex(end)];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }
    private int previousIndex(int index) {return (list.length + index-1) % list.length; }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (!isEmpty()) {
            int i = nextIndex(begin);
            while (i != end) {
                sb.append(list[i]).append(", ");
                i = nextIndex(i);
            }
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
