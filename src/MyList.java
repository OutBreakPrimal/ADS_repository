public interface MyList<T> extends Iterable<T> {
    void add(T item);

    void set(int index, T item);

    void add(int index, T item);

    void remove(int index);

    T get(int index);

    int size();

    boolean isEmpty();

    boolean contains(T item);

    int indexOf(T item);

    void clear();

    void addFirst(T item);

    void addLast(T item);

    void removeFirst();

    void removeLast();

    T getFirst();

    T getLast();

    int indexof(Object object);

    int lastindexof(Object object);

    boolean exists(Object object);

    public Object[] toArray();
}
