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
     * Prints matrix
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int g = 0; g < matrix[i].length; g++) {
                System.out.printf("%4d ",matrix[i][g]);
            }
            System.out.println();
        }
    }
}
