import java.util.*;

public class DepthFirstSearch<V> implements Search<V> {
    private UnweightedGraph<V> graph;

    public DepthFirstSearch(UnweightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<Vertex<V>> search(Vertex<V> start, Vertex<V> goal) {
        Set<Vertex<V>> visited = new HashSet<>();
        Map<Vertex<V>, Vertex<V>> parent = new HashMap<>();
        List<Vertex<V>> path = new ArrayList<>();

        boolean found = dfsHelper(start, goal, visited, parent);
        if (!found) return Collections.emptyList();


        for (Vertex<V> at = goal; at != null; at = parent.get(at)) {
            path.add(0, at);
        }
        return path;
    }

    private boolean dfsHelper(Vertex<V> current, Vertex<V> goal, Set<Vertex<V>> visited, Map<Vertex<V>, Vertex<V>> parent) {
        visited.add(current);
        if (current.equals(goal)) return true;

        for (Vertex<V> neighbor : graph.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, current);
                boolean found = dfsHelper(neighbor, goal, visited, parent);
                if (found) return true;
            }
        }
        return false;
    }
}
