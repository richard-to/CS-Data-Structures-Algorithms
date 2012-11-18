package to.richard;

/**
 * Abstract search class that counts comparisons
 */
public abstract class Search<E> {

    private int comparisons = 0;
    protected Comparable<E>[] sequence;

    abstract public E find(Comparable<E> element);

    /**
     * Resets and comparisons
     * @return Search<E>
     */
    public Search<E> resetComparisons(){
        comparisons = 0;
        return this;
    }

    /**
     * Increments comparisons count
     * @return Search<E>
     */
    public Search<E> incrementComparisons(){
        comparisons++;
        return this;
    }

    /**
     * Sets total comparisons made
     * @return Search<E>
     */
    protected Search<E> setComparisons(int comparisons){
        this.comparisons = comparisons;
        return this;
    }

    /**
     * Gets total comparisons made
     * @return int
     */
    public int getComparisons(){
        return comparisons;
    }

    /**
     * Gets array sequence
     * @return Comparable<E>[]
     */
    public Comparable<E>[] getSequence(){
        return sequence;
    }
}
