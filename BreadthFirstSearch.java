import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        bfs(source);
    }

    private void bfs(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.put(start, true);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!marked.getOrDefault(neighbor, false)) {
                    marked.put(neighbor, true);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
