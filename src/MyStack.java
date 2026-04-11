public class MyStack extends MyArrayList {
    private MyArrayList<Object> kakoitolist = new MyArrayList<>();

    public int getSize() {
        return kakoitolist.size();
    }

    public Object peek() {
        return kakoitolist.getLast();
    }

    public void pop() {
        kakoitolist.removeLast();
    }

    public void push(Object o) {
        kakoitolist.addFirst(o);
    }

    @Override
    public String toString() {
        return "stack: " + kakoitolist.toString();
    }
}
