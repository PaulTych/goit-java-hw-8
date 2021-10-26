package hw8;

import java.util.Objects;

public class MyHashMap<K, V> {
    private K key;
    private V value;
    private final static int DEFAULT_CAPACITY = 5;
    private int size;
    private Node<K, V> mapTable[] = new Node[DEFAULT_CAPACITY];

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return "{" + key + "=" + value + "}";
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            Node<K,V> e = (Node) o;
            if (this.key == e.getKey() && this.value == e.value) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

    static int index(Object key) {
        return (key == null) ? 0 : key.hashCode() % DEFAULT_CAPACITY;
    }

    private int existCell(Object key) {
        if (key == null) {
            if (mapTable[0].getKey() == null) {
                return 0;
            }
        }
        int i = index(key.hashCode());
        if (mapTable[i] == null) {
            return -1;
        } else {
            return i;
        }
    }

    private Node<K, V> existKey(Object key) {
        int i = existCell(key);
        if (i >= 0) {
            Node<K,V> element = mapTable[i];
            for (Node<K, V> n = element; n != null; n = n.next) {
                if (n.getKey() == key) {
                    return n;
                }
            }
            return null;
        }
        return null;
    }

    public void put(Object key, Object value) {
        Node<K, V> element = existKey(key);

        int i = index(key);
        if (element != null) {
            element.value = (V) value;
        } else {
            if (existCell(key) < 0) {
                mapTable[i] = new Node<>(hashCode(), (K) key, (V) value, null);
            } else {
                Node<K, V> last = mapTable[i];
                for (Node<K, V> n = mapTable[i]; n != null; n = n.next) {
                    if (n.next == null) {
                        last = n;
                    }
                }
                last.next =  new Node<>(hashCode(), (K) key, (V) value, null);
            }
            size++;
        }
    }

    public void remove(Object key) {
        if (existKey(key) != null) {
            int i = index(key);
            Node<K, V> element = mapTable[i];
            Node<K, V> prev = mapTable[i];
            for (Node<K, V> n = element; n != null; n = n.next) {
                if (n.getKey() == key) {
                    if (mapTable[i] == n) {
                        mapTable[i] = n.next;
                    } else {
                        prev.next = n.next;
                    }
                }
                n = null;
                size--;
                break;
            }
        }
    }

    public void clear() {
        if (mapTable != null && size > 0) {
            size = 0;
            for (int i = 0; i < mapTable.length; ++i)
                mapTable[i] = null;
        }
    }

    public int size() {
        return size;
    }

    public V get(Object key) {
        Node<K, V> element;
        return (element = existKey(key)) == null ? null : element.value;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < mapTable.length; i++) {
            result += "[";
            for (Node<K, V> n = mapTable[i]; n != null; n = n.next) {
                result += n.toString();
            }
            result += "]";
        }
        return result;
    }
}
