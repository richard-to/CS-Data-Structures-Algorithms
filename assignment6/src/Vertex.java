/**
 * Simple vertex class modified for dijkstra and assignment
 */
class Vertex {
    public int id;
    public String city;
    public boolean visited = false;
    public int legCost = 0;
    public int totalCost = 0;
    public Vertex predecessor = null;
    public Vertex(int id, String city) {
        this.id = id;
        this.city = city;
    }
}