package to.richard;

/**
 * Uses binary search to find element
 */
public class BinarySearch<E> extends Search<E> {

    /**
     * Constructor
     * @param sequence Array of elements in any order
     */
    public BinarySearch(Comparable<E>[] sequence){
        QuickSort<E> quickSort = new QuickSort<E>();
        this.sequence = (Comparable<E>[])quickSort.sort(sequence.clone());
    }

    /**
     * Finds element using binary search
     * Returns null if not found
     * @param element
     * @return E
     */
    public E find(Comparable<E> element){
        resetComparisons();
        Comparable<E> foundElement = find(element, sequence, 0, sequence.length-1);
        return (foundElement != null) ? (E)foundElement : null;
    }

    /**
     * Find element using recursive binary search
     * @param element
     * @param sequence
     * @param min Inclusive
     * @param max Inclusive
     * @return Comparable<E>;
     */
    private Comparable<E> find(Comparable<E> element, Comparable<E>[] sequence, int min, int max){
        int mid = max - ((max - min) / 2);
        int elementVsSequence = element.compareTo((E)sequence[mid]);
        incrementComparisons();
        if(elementVsSequence == 0){
            return element;
        } else if(max == min) {
            return null;
        } if(elementVsSequence > 0){
            return find(element, sequence, mid+1, max);
        } else {
            return find(element, sequence, min, mid-1);
        }
    }
}
