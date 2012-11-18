package to.richard;

public class LinearSearch<E> extends Search<E> {

    Comparable<E>[] sequence;

    /**
     * Constructor
     * @param sequence Array of elements in any order
     */
    public LinearSearch(Comparable<E>[] sequence){
        this.sequence = sequence;
    }

    /**
     * Finds element using linear search
     * Returns null if not found
     * @param element
     * @return E
     */
    public E find(Comparable<E> element){
        for(int i = 0; i < sequence.length; i++){
            incrementComparisons();
            if(sequence[i].compareTo((E)element) == 0){
                return (E)element;
            }
        }
        return null;
    }
}
