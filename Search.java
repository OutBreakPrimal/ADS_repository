import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Search<V> {
    protected Vertex<V> source;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected Map<Vertex<V>, Boolean> marked;

    public Search(Vertex<V> source) {
        this.source = source;
        this.edgeTo = new HashMap<>();
        this.marked = new HashMap<>();
    }

    public List<Vertex<V>> pathTo(Vertex<V> destination) {
        if (!hasPathTo(destination))
            return null;

        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> v = destination; !v.equals(source); v = edgeTo.get(v)) {
            path.addFirst(v);
        }
        path.addFirst(source);
        return path;
    }

    public boolean hasPathTo(Vertex<V> destination) {
        return marked.getOrDefault(destination, false);
    }
}
