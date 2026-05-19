import java.util.ArrayList;
import java.util.List;

public class WeightedGraph<V> {
    private List<Vertex<V>> vertices;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.vertices = new ArrayList<>();
        this.directed = directed;
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight);
        if (!directed) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public List<Vertex<V>> getVertices() {
        return vertices;
    }

    public void printGraph() {
        for (Vertex<V> vertex : vertices) {
            System.out.print(vertex + " -> ");
            for (var entry : vertex.getAdjacentVertices().entrySet()) {
                System.out.print(entry.getKey() + " (weight=" + entry.getValue() + ")  ");
            }
            System.out.println();
        }
    }
}
