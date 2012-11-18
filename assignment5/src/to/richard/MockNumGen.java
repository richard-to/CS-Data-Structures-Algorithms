package to.richard;

import java.util.Random;

/**
 * Testable NumGen that overrides random generator with Queue
 */
public class MockNumGen extends NumGen {
    private Queue<Integer> randSequence;

    /**
     * If unique constructor should check if max is greater than count
     * @param max Range from 0 to max for which to generate random numbers. Should be positive number.
     * @param count Total number of numbers to generate. Positive numbers only.
     * @param unique If unique, then can't have duplicates
     * @param randSequence An queue to use in place of random numbers
     */
    public MockNumGen(int max, int count, boolean unique, Queue<Integer> randSequence){
        super(max, count, unique);
        this.randSequence = randSequence;
    }

    public int getRandom(){
        return randSequence.dequeue();
    }
}
