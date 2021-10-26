package hw8;

public class MyLinkedList <E> implements MyList{
    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node <T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        Node (T item, Node<T> prev, Node<T> next) {
            this.item =  item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(Object value) {
        final Node <E> last = this.last;
        final Node <E> newNode = new Node<>((E) value, last, null);
        this.last = newNode;
        if (last == null)
            this.first = newNode;
        else
            last.next = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        int i = 0;
        if (index<0|| index>this.size){
            throw new IndexOutOfBoundsException();
        }
        if (this.first != null) {
            Node<E> curItem = this.first;
            while (i < index) {
                curItem = curItem.next;
                i++;
            }
            if (curItem.next != null) {
                curItem.next.prev = curItem.prev;
            }
            if (curItem.prev != null) {
                curItem.prev.next = curItem.next;
            }
            curItem = null;
            this.size--;
        }
    }

    @Override
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

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        int curIndex = 0;
        Node <E> curNode = this.first;
        if (index>this.size){
            throw new IndexOutOfBoundsException();
        }
        if (curNode != null) {
            while (curIndex < index) {
                curNode = curNode.next;
                curIndex++;
            }
            return curNode.item;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Node<E> n = first; n != null; n = n.next) {
            result += n == first ? "": ",";
            result += "{" + "[" + n.item.toString() + "][" + (n.prev== null?"null":n.prev.hashCode()) + "][" + (n.next== null?"null":n.next.hashCode()) + "]}";
        }
        return result;
    }
}
