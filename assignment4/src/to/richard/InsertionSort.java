package to.richard;

/**
 * Generic insertion sort implementation
 */
public class InsertionSort<E> extends Sort<E> {

    /**
     * Sorts array using insertion sort.
     *
     * Will return a reference to sorted array, but it is kind of pointless
     * since the array is passed by reference and the sorting is done on
     * the array passed into the method.
     *
     * @param elements Elements must implement Comparable interface
     * @return E[]
     */
    public E[] sort(Comparable<E>[] elements) {
        resetSwapsAndComparisons();

        int i;
        int j;
        int outerLen = elements.length;

        for(i = 1; i < outerLen; i++){
            Comparable<E> insertElement = elements[i];
            for(j = i - 1; j >= 0; j--){
                incrementComparisons();
                if(insertElement.compareTo((E)elements[j]) < 0){
                    incrementSwaps();
                    elements[j+1] = elements[j];
                } else {
                    break;
                }
            }
            incrementSwaps();
            elements[j+1] = insertElement;
        }
        return (E[]) elements;
    }
}