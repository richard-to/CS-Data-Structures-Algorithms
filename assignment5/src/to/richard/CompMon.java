package to.richard;

/**
 * Monitors comparisons for finding elements
 * Tracks min, max, and avg comparisons
 */
public class CompMon<E> {
    private int min;
    private int max;
    private int total;
    private int runs;

    Search<E> search;

    public CompMon(){}

    public CompMon(Search<E> search){
        setSearch(search);
    }

    /**
     * Runs search on all elements of array and track stats.
     * Stats will reset before running.
     * Not that this will fail if search is not set.
     * @return CompMon<E>
     */
    public CompMon<E> run(){
        Comparable<E>[] sequence = search.getSequence();
        for(int i = 0; i < sequence.length; i++){
            search.find(sequence[i]);
            int comparisons = search.getComparisons();
            incrementRuns();
            addTotal(comparisons);
            setMax(comparisons);
            setMin(comparisons);

        }
        return this;
    }

    /**
     * Sets search object to use.
     * Will reset stats;
     * @param search
     * @return CompMon<E>
     */
    public CompMon<E> setSearch(Search<E> search){
        this.search = search;
        resetStats();
        return this;
    }

    /**
     * Resets stats to 0
     * @return CompMon<E>
     */
    public CompMon<E> resetStats(){
        min = -1;
        max = 0;
        total = 0;
        runs = 0;
        return this;
    }

    /**
     * Sets min value if value is min
     * @param min
     * @return CompMon<E>
     */
    public CompMon<E> setMin(int min) {
        if(this.min == -1 || this.min > min)
            this.min = min;
        return this;
    }

    /**
     * Sets max value if value is max
     * @param max
     * @return CompMon<E>
     */
    public CompMon<E> setMax(int max) {
        if(this.max < max)
            this.max = max;
        return this;
    }

    /**
     * Adds comparisons to total
     * @param comparisons
     * @return CompMon<E>
     */
    public CompMon<E> addTotal(int comparisons) {
        this.total += comparisons;
        return this;
    }

    /**
     * Increments number of runs by 1
     * @return CompMon<E>
     */
    public CompMon<E> incrementRuns() {
        this.runs++;
        return this;
    }

    /**
     * Gets avg comparisons
     * @return float
     */
    public float getAvg() {
        return (runs == 0) ? 0 : (float)total/runs;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getRuns() {
        return runs;
    }

    public int getTotal() {
        return total;
    }

    public void printResults(){
        System.out.println("Total Runs: " + getRuns());
        System.out.println("Total: " + getTotal());
        System.out.println("Avg: " + getAvg());
        System.out.println("Max: " + getMax());
        System.out.println("Min: " + getMin());
    }
}
