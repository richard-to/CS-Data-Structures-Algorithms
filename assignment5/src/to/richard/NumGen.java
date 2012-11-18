package to.richard;

import java.util.HashMap;
import java.util.Random;

/**
 * Generates a sequence of numbers
 */
public class NumGen {
    private int max;
    private int count;
    private boolean unique;
    private Random rand;

    public NumGen() {
        this(2000000, 1000, true);
    }

    /**
     * If unique constructor should check if max is greater than count
     * @param max Range from 0 to max for which to generate random numbers. Should be positive number.
     * @param count Total number of numbers to generate. Positive numbers only.
     * @param unique If unique, then can't have duplicates
     */
    public NumGen(int max, int count, boolean unique){
        this.max = max;
        this.count = count;
        this.unique = unique;
        this.rand = new Random();
    }

    /**
     * Generates an array of random numbers
     * @return int[]
     */
    public int[] generate(){
        return (unique) ? generateUnique() : generateNonUnique();
    }

    /**
     * Gets random integer from 0 to max
     * @return int
     */
    public int getRandom() {
        return rand.nextInt(max) + 1;
    }

    /**
     * Generates sequence of numbers that are unique
     * @return int[]
     */
    private int[] generateUnique(){
        int[] sequence = new int[count];
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        int i = 0;
        while(i < count){
            int nextInt = getRandom();
            if(!hash.containsKey(nextInt)){
                hash.put(nextInt, i);
                sequence[i] = nextInt;
                i++;
            }
        }
        return sequence;
    }

    /**
     * Generates sequence of numbers that allows duplicates
     * @return int[]
     */
    private int[] generateNonUnique(){
        int[] sequence = new int[count];
        Random rand = new Random();
        int i = 0;
        while(i < count){
            int nextInt = getRandom();
            sequence[i] = nextInt;
            i++;
        }
        return sequence;
    }
}
