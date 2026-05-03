import org.w3c.dom.Node;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }

    }

    private Object[] chainArray;
    private int size;
    private double loadFactor = 0.75;
    private double threshold = size * loadFactor;

    public MyHashTable() {
        this(11);
    }

    public MyHashTable(int initialCapacity) {
        this(initialCapacity, (float) 0.75);
    }

    public MyHashTable(int initialCapacity, float loadFactor) {
        if (initialCapacity == 0) {
            initialCapacity = 1;
        }

        chainArray = new HashNode[initialCapacity];
    }

    private int hash() {
        int result = 1;
        result = 31 * result + chainArray.hashCode();
        return result;
    }

    public void put(K key, V value) {
        Object tab[] = chainArray;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        chainArray[size++] = newNode;
        if (size > threshold) {
            increaseCapacity();
        }
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        HashNode<K, V> entry = (HashNode<K, V>) tab[index];
        for (; entry != null; entry = entry.next) {
            if ((entry.hashCode() == hash) && entry.key.equals(key)) {
                V prev = entry.value;
                entry.value = value;
                System.out.print(prev);
            }
        }
    }

    public V get(K key) {
        Object tab[] = chainArray;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (HashNode<K, V> i = (MyHashTable<K, V>.HashNode<K, V>) tab[index]; i != null; i = i.next) {
            if ((i.hashCode() == hash) && i.key.equals(key)) {
                return (V) i.value;
            }
        }
        return null;
    }

    public K getKey(V value) {
        Object tab[] = chainArray;
        int hash = value.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (HashNode<K, V> i = (MyHashTable<K, V>.HashNode<K, V>) tab[index]; i != null; i = i.next) {
            if ((i.hashCode() == hash) && i.key.equals(value)) {
                return (K) i.key;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        boolean da_net = false;
        Object tab[] = chainArray;
        int hash = value.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (HashNode<K, V> i = (MyHashTable<K, V>.HashNode<K, V>) tab[index]; i != null; i = i.next) {
            if ((i.hashCode() == hash) && i.key.equals(value)) {
                da_net = true;
            } else {
                da_net = false;
            }
        }
        return da_net;
    }

    public V remove(K key) {
        HashNode<K, V>[] tab = (MyHashTable<K, V>.HashNode<K, V>[]) chainArray;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        HashNode<K, V> e = (HashNode<K, V>) tab[index];
        for (HashNode<K, V> prev = null; e != null; prev = e, e = e.next) {
            if (e.hashCode() == hash && e.equals(key)) {
                if (prev != null)
                    prev.next = e.next;
                else
                    tab[index] = e.next;

                e.value = null;
            }
        }
        return null;
    }

    private void increaseCapacity() {
        if (size > threshold) {
            Object[] newElements = new Object[chainArray.length * 2];

            for (int i = 0; i < chainArray.length; i++) {
                newElements[i] = chainArray[i];
            }

            chainArray = newElements;
        }
    }

    public int size() {
        return size;
    }

    public int[] getBucketsSizes(int initialCapacity) {
        int[] sizes = new int[initialCapacity];

        for (int i = 0; i < initialCapacity; i++) {
            int count = 0;
            HashNode<K, V> current = (MyHashTable<K, V>.HashNode<K, V>) chainArray[i];

            while (current != null) {
                count++;
                current = current.next;
            }

            sizes[i] = count;
        }

        return sizes;
    }
}