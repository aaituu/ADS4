public class Edge<V> {
    private Vertex<V> from;
    private Vertex<V> to;
    private double weight;

    public Edge(Vertex<V> from, Vertex<V> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex<V> getFrom() {
        return from;
    }

    public Vertex<V> getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return from + " -> " + to + " (" + weight + ")";
    }
}
