import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyList = new HashMap<>();
    private Map<Vertex<V>, Map<Vertex<V>, Double>> weights = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        weights.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<V> from, Vertex<V> to, double weight) {
        addVertex(from);
        addVertex(to);

        adjacencyList.get(from).add(to);
        weights.get(from).put(to, weight);


        adjacencyList.get(to).add(from);
        weights.get(to).put(from, weight);
    }

    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptyList());
    }

    public double getWeight(Vertex<V> from, Vertex<V> to) {
        return weights.getOrDefault(from, Collections.emptyMap()).getOrDefault(to, Double.POSITIVE_INFINITY);
    }

    public Set<Vertex<V>> getVertices() {
        return adjacencyList.keySet();
    }
}
