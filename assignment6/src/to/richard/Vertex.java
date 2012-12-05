package to.richard;

/**
 * Represents a vertex in a graph
 */
public class Vertex {
    private LinkedList<Edge> edges;
    private String value;
    private boolean visited;

    public Vertex(String value) {
        edges = new LinkedList<Edge>();
        this.value = value;
        visited = false;
    }

    /**
     * Adds edge
     * @param vertex
     * @return Vertex
     */
    public Vertex addEdge(Vertex vertex, int weight) {
        edges.add(new Edge(vertex, weight));
        return this;
    }

    /**
     * Marks Vertex as visited
     * @param isVisited
     * @return Vertex
     */
    public Vertex setVisited(boolean isVisited) {
        visited = isVisited;
        return this;
    }

    /**
     * Gets value
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value
     * @param value
     * @return Vertex
     */
    public Vertex setValue(String value) {
        this.value = value;
        return this;
    }
}
