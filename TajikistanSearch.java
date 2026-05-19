import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TajikistanSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;

    public TajikistanSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        distTo = new HashMap<>();

        for (Vertex<V> v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);
        marked.put(source, true);

        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(distTo.getOrDefault(a, Double.MAX_VALUE),
                        distTo.getOrDefault(b, Double.MAX_VALUE)));
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double newDist = distTo.get(current) + entry.getValue();

                if (newDist < distTo.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    marked.put(neighbor, true);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double distanceTo(Vertex<V> destination) {
        return distTo.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }
}
