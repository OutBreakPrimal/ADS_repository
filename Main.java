import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeightedGraph<String> graph = new WeightedGraph<>(false);

        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> karaganda = new Vertex<>("Karaganda");
        Vertex<String> kostanai = new Vertex<>("Kostanai");

        graph.addVertex(almaty);
        graph.addVertex(astana);
        graph.addVertex(shymkent);
        graph.addVertex(karaganda);
        graph.addVertex(kostanai);

        graph.addEdge(almaty, kostanai, 700);
        graph.addEdge(almaty, karaganda, 1400);
        graph.addEdge(karaganda, kostanai, 1200);
        graph.addEdge(karaganda, shymkent, 1488);
        graph.addEdge(astana, shymkent, 1100);
        graph.addEdge(astana, karaganda, 6767);
        graph.addEdge(shymkent, astana, 2100);
        graph.addEdge(shymkent, almaty, 6969);

        System.out.println("Graph structure");
        graph.printGraph();

        Map<String, Vertex<String>> cityMap = new HashMap<>();
        for (Vertex<String> v : graph.getVertices()) {
            cityMap.put(v.getData().toLowerCase(), v);
        }
        System.out.println("type where are you going from");
        String fromOg = scanner.nextLine().trim().toLowerCase();
        System.out.println("To where");
        String toOg = scanner.nextLine().trim().toLowerCase();
        Vertex<String> from = cityMap.get(fromOg);
        Vertex<String> to = cityMap.get(toOg);

        System.out.println("BFS shortest path (by least visited vertixes)");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, from);

        printPath(bfs.pathTo(to), fromOg + " - " + toOg);

        System.out.println("Dijkstra shortest path (by weight)");
        TajikistanSearch<String> tajik = new TajikistanSearch<>(graph, from);

        printPath(tajik.pathTo(to), fromOg + " - " + toOg + " " + tajik.distanceTo(to));
    }

    private static <V> void printPath(List<Vertex<V>> path, String label) {
        if (path == null) {
            System.out.println(label + ": no path found");
            return;
        }
        System.out.print(label + ": ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).getData());
            if (i < path.size() - 1)
                System.out.print(" -> ");
        }
        System.out.println();
    }
}
