package to.richard;

public abstract class Sort<E> {

    private int swaps = 0;
    private int comparisions = 0;

    abstract public E[] sort(Comparable<E>[] elements);

    /**
     * Resets swaps and comparisons
     * @return Sort<E>
     */
    public Sort<E> resetSwapsAndComparisons(){
        swaps = 0;
        comparisions = 0;
        return this;
    }

    /**
     * Increments comparisons count
     * @return Sort<E>
     */
    public Sort<E> incrementComparisons(){
        comparisions++;
        return this;
    }

    /**
     * Increments swaps count
     * @return Sort<E>
     */
    public Sort<E> incrementSwaps(){
        swaps++;
        return this;
    }
    /**
     * Gets total swaps made
     * @return int
     */
    public int getSwaps(){
        return swaps;
    }

    /**
     * Gets total comparisons made
     * @return int
     */
    public int getComparisions(){
        return comparisions;
    }
}