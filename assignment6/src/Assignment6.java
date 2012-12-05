import java.util.Random;

/**
 * Alaska Travel Agent Problem
 */
public class Assignment6 {

    public static final int MATRIX_SIZE = 50;
    public static final int MIN_PRICE = 99;
    public static final int MAX_PRICE = 1499;

    /**
     * Lists of 50 largest cities by population plus Anchorage
     */
    public static final String[] cities = {
        "Anchorage",
        "New York",
        "Los Angeles",
        "Chicago",
        "Houston",
        "Philadelphia",
        "Phoenix",
        "San Antonio",
        "San Diego",
        "Dallas",
        "San Jose",
        "Jacksonville",
        "Indianapolis",
        "San Francisco",
        "Austin",
        "Columbus",
        "Fort Worth",
        "Charlotte",
        "Detroit",
        "El Paso",
        "Memphis",
        "Baltimore",
        "Boston",
        "Seattle",
        "Washington",
        "Nashville-Davidson",
        "Denver",
        "Louisville-Jefferson County",
        "Milwaukee",
        "Portland",
        "Las Vegas",
        "Oklahoma City",
        "Albuquerque",
        "Tucson",
        "Fresno",
        "Sacramento",
        "Long Beach",
        "Kansas City",
        "Mesa",
        "Virginia Beach",
        "Atlanta",
        "Colorado Springs",
        "Omaha",
        "Raleigh",
        "Miami",
        "Cleveland",
        "Tulsa",
        "Oakland",
        "Minneapolis",
        "Wichita",
        "Arlington"
    };

    /**
     * Main Program
     * @param args
     */
    public static void main(String[] args) {
        System.out.printf("Building price matrix for %d destinations...\n\n", MATRIX_SIZE-1);
        int[][] matrix = buildMatrix(MATRIX_SIZE, MIN_PRICE, MAX_PRICE);
        printMatrix(matrix);
        System.out.printf("Finding cheapest routes to %d destinations...\n\n", MATRIX_SIZE-1);
        Vertex[] vertexes = dijkstra(matrix);
        printShortestPaths(vertexes);
    }

    /**
     * Builds price matrix
     * @param size
     * @param minPrice
     * @param maxPrice
     * @return price matrix
     */
    public static int[][] buildMatrix(int size, int minPrice, int maxPrice) {
        Random rand = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int g = 0; g < size; g++) {
                matrix[i][g] = rand.nextInt(maxPrice - minPrice + 1) + minPrice;
            }
        }
        return matrix;
    }

    /**
     * My version of dijkstra. A bit inefficient, but it works.
     * @param matrix
     * @return Vertex[]
     */
    public static Vertex[] dijkstra(int[][] matrix) {

        int  visitedCount = 1;

        Vertex[] vertexes = new Vertex[matrix.length];
        for (int i = 0; i < vertexes.length; i++) {
            vertexes[i] = new Vertex(i, cities[i]);
        }
        vertexes[0].visited = true;

        int[] from = new int[matrix.length];
        from[0] = vertexes[0].id;

        while (true) {

            int minFrom = 0;
            int minTo = 0;
            int minCost = 0;

            for (int i = 0; i < visitedCount; i++) {
                for (int g = 0; g < matrix[from[i]].length; g++) {
                    if (!vertexes[g].visited &&
                            (minCost == 0 || vertexes[from[i]].totalCost + matrix[from[i]][g] < minCost)) {
                        minTo = g;
                        minFrom = from[i];
                        minCost = matrix[from[i]][g];
                    }
                }
            }

            vertexes[minTo].visited = true;
            vertexes[minTo].legCost = minCost;
            vertexes[minTo].totalCost += minCost + vertexes[minFrom].totalCost;
            vertexes[minTo].predecessor = vertexes[minFrom];

            from[visitedCount++] = minTo;
            if (visitedCount == matrix.length) {
                break;
            }
        }
        return vertexes;
    }

    /**
     * Prints shortest paths of destinations from Anchorage
     * @param vertexes
     */
    public static void printShortestPaths(Vertex[] vertexes) {

        String[] route = new String[vertexes.length];
        int legCount = 1;
        for (int i = 1; i < vertexes.length; i++) {
            legCount = 0;
            System.out.printf("Destination %s\n", vertexes[i].city);
            System.out.println("==================================");

            Vertex to = vertexes[i];
            Vertex from = null;
            while (true) {
                from = to.predecessor;
                if (from != null) {
                    route[legCount++] = String.format("$%4d %s to %s", to.legCost, from.city, to.city);
                    to = from;
                } else {
                    break;
                }
            }

            for (int g = legCount - 1; g >= 0; g--) {
                System.out.printf("%2d. %s\n", legCount - g, route[g]);
            }

            System.out.println("-------------------------------------");
            System.out.printf("    $%4d Total Cost", vertexes[i].totalCost);
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Prints matrix
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int g = 0; g < matrix[i].length; g++) {
                System.out.printf("%4d ", matrix[i][g]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
