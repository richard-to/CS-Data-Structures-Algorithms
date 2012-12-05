package to.richard;

/**
 * Graph implementation
 */
public class Graph {
    private LinkedList<Vertex> vertexes;

    public Graph() {
        vertexes = new LinkedList<Vertex>();
    }

    /**
     * Add vertex to graph
     * @param vertex
     * @return self
     */
    public Graph addVertex(Vertex vertex) {
        vertexes.add(vertex);
        return this;
    }

    /**
     * Add edge to graph
     * @param vertex1
     * @param vertex2
     * @param weight
     * @return self
     */
    public Graph addEdge(Vertex vertex1, Vertex vertex2, int weight) {
        if(vertexes.contains(vertex1) && vertexes.contains(vertex2)) {
            vertex1.addEdge(vertex2, weight);
            vertex2.addEdge(vertex1, weight);
        }
        return this;
    }
}
