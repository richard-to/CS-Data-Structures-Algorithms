package to.richard.test;

import org.junit.Test;
import to.richard.Graph;
import to.richard.Vertex;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void testGraphAddVertex() {
        Vertex v1 = new Vertex("Test");
        Vertex v2 = new Vertex("Test2");
        Vertex v3 = new Vertex("Test3");
        Vertex v4 = new Vertex("Test4");
        Graph g = new Graph();
        g.addVertex(v1).addVertex(v2).addVertex(v3);
        g.addEdge(v1, v2, 2).addEdge(v3, v4, 3);
    }
}
