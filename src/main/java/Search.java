import java.util.List;

public interface Search<V> {
    List<Vertex<V>> search(Vertex<V> start, Vertex<V> goal);
}
