import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<Vertex<V>> search(Vertex<V> start, Vertex<V> goal) {
        Map<Vertex<V>, Vertex<V>> parent = new HashMap<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (current.equals(goal)) break;

            for (Vertex<V> neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!parent.containsKey(goal)) return Collections.emptyList();

        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = goal; at != null; at = parent.get(at)) {
            path.addFirst(at);
        }
        return path;
    }
}
