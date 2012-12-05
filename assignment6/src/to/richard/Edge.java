package to.richard;

/**
 * Represents a a weighted edge in a graph
 */
public class Edge {
    public Vertex vertex;
    public int weight;

    public Edge(Vertex vertex) {
        this(vertex, 0);
    }

    public Edge(Vertex vertex, int weight) {
        this.vertex = vertex;
        this.weight = 0;
    }
}
