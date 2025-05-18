import java.util.*;

public class UnweightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyList = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> from, Vertex<V> to) {
        addVertex(from);
        addVertex(to);

        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);  // неориентированный граф
    }

    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptyList());
    }

    public Set<Vertex<V>> getVertices() {
        return adjacencyList.keySet();
    }
}
