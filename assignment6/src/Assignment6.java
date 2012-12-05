import java.util.Random;

/**
 * Alaska Travel Agent Problem
 */
public class Assignment6 {

    public static final int MATRIX_SIZE = 3;
    public static final int MIN_PRICE = 99;
    public static final int MAX_PRICE = 1499;

    /**
     * Main Program
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = buildMatrix(MATRIX_SIZE, MIN_PRICE, MAX_PRICE);
        dijkstra(matrix);
        printMatrix(matrix);
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
     * My version of dijkstra. A bit inefficient
     * @param matrix
     */
    public static void dijkstra(int[][] matrix) {
        int  visitedCount = 1;
        boolean[] visited = new boolean[matrix.length];
        int[] totalCost = new int[matrix.length];
        int[] predecessor = new int[matrix.length];

        visited[0] = true;
        totalCost[0] = 0;
        predecessor[0] = 0;

        int[] from = new int[matrix.length];
        from[0] = 0;

        while (true) {

            int minFrom = 0;
            int minTo = 0;
            int minCost = 0;

            for (int i = 0; i < visitedCount; i++) {
                for (int g = 0; g < matrix[from[i]].length; g++) {
                    if (!visited[g] && (minCost == 0 || matrix[from[i]][g] < minCost)) {
                        minTo = from[visitedCount++] = g;
                        minFrom = from[i];
                        minCost = matrix[from[i]][g];
                    }
                }
            }
            visited[minTo] = true;
            totalCost[minTo] += minCost;
            predecessor[minTo] = minFrom;
            if(visitedCount == matrix.length) {
                break;
            }
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
    }
}
