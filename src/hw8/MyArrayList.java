package hw8;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<E> implements MyList {
    private E[] array;
    private final static int DEFAULT_SIZE = 10;
    private int size = 0;
    private final static double LOAD_FACTOR = (double) 3 / 2 + 1;

    public MyArrayList(Class<E> clazz) {
        this.array = (E[]) Array.newInstance(clazz, DEFAULT_SIZE);
    }

    @Override
    public void add(Object value) {
        if (array.length <= size) {
            int newSize = (int) (array.length * LOAD_FACTOR);
            array = Arrays.copyOf(array, newSize);
        }
        array[this.size] = (E) value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index > 0 && index <= array.length) {
            array[index] = null;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    @Override
    public int size() {
        if (array != null) {
            return array.length;
        } else {
            return -1;
        }
    }

    @Override
    public E get(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (array == null) {
            return null;
        } else {
            return array[index];
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                result += i == 0 ? "{null}" : ",{null}";
            } else {
                result += (i == 0 ? "{" + array[i] : ",{" + array[i]) + "}";
            }
        }
        return result;
    }
}

