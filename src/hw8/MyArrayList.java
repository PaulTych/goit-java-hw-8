package hw8;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<E>  {
    private E[] array;

    public MyArrayList(Class<E> clazz, int size) {
        this.array = (E[]) Array.newInstance(clazz, size);
    }

    public void add(E value) {
        int size = this.array.length;
        array = Arrays.copyOf(array, size + 1);
        array[size] =  value;
        // size++;
    }

    public void remove(int index) {
        E[] tempArray = this.array;
        int j = 0;
        if (index > 0 && index <= array.length) {
            for (int i = 0; i < this.array.length; i++) {
                if (i != index) {
                    tempArray[j++] = this.array[i];
                }
            }
            this.array = Arrays.copyOf(tempArray, this.array.length - 1);
        } else {
            throw new IndexOutOfBoundsException();
        }
        //  this.size --;
    }

    public void clear() {
        this.array = null;
    }
    //this.size =0;


    public int size() {
        if (array != null) {
            return array.length;
        } else {
            return -1;
        }
    }

    public E get(int index) {
        if (index > this.array.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (this.array == null) {
            return null;
        } else {
            return array[index];
        }
    }

    @Override
    public String toString() {
        String result = "";
        if (this.array==null){
            result = "";
        } else {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                result += i == 0 ? "{null}" : ",{null}";
            } else {
                result += (i == 0 ? "{" + array[i] : ",{" + array[i]) + "}";
            }
        }}
        return result;
    }
}

