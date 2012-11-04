import to.richard.*;

import java.io.IOException;

/**
 * Main application class
 */
public class Assignment4 {

    private static final String WORDS_FILE = "words.txt";
    private static final int MAX_TOKENS = 1000;

    public static void main(String[] args) throws IOException {
        String[] tokens = TextTokenizer.tokenizeFile(WORDS_FILE, MAX_TOKENS);

        sortTest("Insertion Sort Test", tokens, new InsertionSort<String>());
        sortTest("Selection Sort Test", tokens, new SelectionSort<String>());
        sortTest("Merge Sort Test", tokens, new MergeSort<String>());
        sortTest("Quick Sort Test", tokens, new QuickSort<String>());
    }

    public static void sortTest(String title, String[] tokens, ISort sorter) {
        System.out.println(title);
        System.out.println("----------------------------");
        System.out.println("Original Order");
        TextTokenizer.print(tokens);
        System.out.println();

        System.out.println("First Sort");
        String[] copy = TextTokenizer.copy(tokens);
        sorter.sort(copy);
        TextTokenizer.print(copy);
        System.out.println();

        System.out.println("Second Sort");
        sorter.sort(copy);
        TextTokenizer.print(copy);
        System.out.println();
    }
}
