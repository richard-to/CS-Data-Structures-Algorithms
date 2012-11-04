package to.richard;

import java.io.*;

/**
 * Helper functions for assignment 4
 */
public class TextTokenizer {

    /**
     * Tokenizes file in an array of words
     * @param filePath
     * @param maxTokens
     * @return String[]
     */
    public static String[] tokenizeFile(String filePath, int maxTokens) throws IOException {
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String[] tokens = new String[maxTokens];
        String token;

        int tokenCount = 0;
        while(tokenCount < maxTokens && (token = br.readLine()) != null) {
            tokens[tokenCount++] = token;
        }
        return tokens;
    }

    /**
     * Copy array of words into another array
     * @param tokens
     * @return String[]
     */
    public static String[] copy(String[] tokens){
        int tokenCount = tokens.length;
        String[] copy = new String[tokenCount];
        for(int i = 0; i < tokenCount; i++)
            copy[i] = tokens[i];
        return copy;
    }

    /**
     * Prints words in array. One line per word
     * @param tokens
     */
    public static void println(String[] tokens){
        int tokenCount = tokens.length;
        for(int i = 0; i < tokenCount; i++)
            System.out.println(tokens[i]);
    }

    /**
     * Prints words in array. Space per word
     * @param tokens
     */
    public static void print(String[] tokens){
        int tokenCount = tokens.length;
        for(int i = 0; i < tokenCount; i++){
            System.out.print(tokens[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
