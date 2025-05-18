import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<Vertex<V>> search(Vertex<V> start, Vertex<V> goal) {
        Map<Vertex<V>, Double> dist = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> parent = new HashMap<>();
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(vd -> vd.distance));

        for (Vertex<V> vertex : graph.getVertices()) {
            dist.put(vertex, Double.POSITIVE_INFINITY);
        }
        dist.put(start, 0.0);
        parent.put(start, null);
        pq.add(new VertexDistance<>(start, 0.0));

        while (!pq.isEmpty()) {
            VertexDistance<V> vd = pq.poll();
            Vertex<V> current = vd.vertex;

            if (current.equals(goal)) break;

            if (vd.distance > dist.get(current)) continue;

            for (Vertex<V> neighbor : graph.getNeighbors(current)) {
                double newDist = dist.get(current) + graph.getWeight(current, neighbor);
                if (newDist < dist.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    dist.put(neighbor, newDist);
                    parent.put(neighbor, current);
                    pq.add(new VertexDistance<>(neighbor, newDist));
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

    private static class VertexDistance<V> {
        Vertex<V> vertex;
        double distance;

        public VertexDistance(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
