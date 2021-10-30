package hw8;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    private int size;
    private final int CAPACITY = 20;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(Object value) {
        final Node<E> last = this.last;
        final Node<E> newNode = new Node<>((E) value, last, null);
        if (this.size > CAPACITY) {
            throw new IllegalStateException();
        }
        this.last = newNode;
        if (last == null)
            this.first = newNode;
        else
            last.next = newNode;
        size++;
    }

    public void remove(int index) {
        int i = 0;
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.first != null) {
            Node<E> curItem = this.first;
            while (i <index) {
                curItem = curItem.next;
                i++;
            }
            if (curItem.next != null) {
                curItem.next.prev = curItem.prev;
            }
            if (curItem.prev != null) {
                curItem.prev.next = curItem.next;
            } else {
                this.first= curItem.next;
            }
            this.size--;
        }
    }

    public void clear() {
        for (Node<E> n = first; n != null; n = n.next) {
            n.item = null;
            n.next = null;
            n.prev = null;
        }
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public E peek() {
        if (this.size <= 0) {
            throw new NoSuchElementException();
        }
        return this.first.item;
    }

    public E poll() {
        if (this.size < 0) {
            throw new NoSuchElementException();
        }
        remove(0);
        return this.first.item;
    }

    @Override
    public String toString() {
        String result = "";
        for (Node<E> n = first; n != null; n = n.next) {
            result += n == first ? "" : ",";
            result += "{" + "[" + n.item.toString() + "][" + (n.prev == null ? "null" : n.prev.hashCode()) + "][" + (n.next == null ? "null" : n.next.hashCode()) + "]}";
        }
        return result;
    }
}
