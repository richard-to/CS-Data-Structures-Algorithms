package to.richard;

public class SelectionSort<E> implements ISort<E> {

    /**
     * Sorts array using selection sort.
     *
     * Will return a reference to sorted array, but it is kind of pointless
     * since the array is passed by reference and the sorting is done on
     * the array passed into the method.
     *
     * @param elements Elements must implement Comparable interface
     * @return E[]
     */
    public E[] sort(Comparable<E>[] elements) {
        int outerLen = elements.length - 1;
        int innerLen = elements.length;

        for(int i = 0; i < outerLen; i++) {
            int indexBest = i;
            for(int j = i+1; j < innerLen; j++) {
                if(elements[indexBest].compareTo((E)elements[j]) > 0) {
                    indexBest = j;
                }
            }

            if(indexBest != i){
                Comparable<E> tmp = elements[i];
                elements[i] = elements[indexBest];
                elements[indexBest] = tmp;
            }
        }
        return (E[]) elements;
    }
}
