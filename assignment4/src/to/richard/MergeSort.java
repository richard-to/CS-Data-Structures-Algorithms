package to.richard;

/**
 * Generic implementation of merge sort
 *
 * @param <E>
 */
public class MergeSort<E> extends Sort<E> {

    private Comparable<E>[] tmpElements;

    /**
     * Sorts array using merge sort.
     *
     * @param elements Array of elements implementing comparable
     * @return E[]
     */
    public E[] sort(Comparable<E>[] elements){
        resetSwapsAndComparisons();
        tmpElements = (Comparable<E>[]) new Comparable[elements.length];
        mergeSort(elements, 0, elements.length);
        return (E[])elements;
    }

    private void mergeSort(
            Comparable<E>[] elements, int start, int len){

        if(len > 1){
            int leftLen = len / 2;
            int leftStart = start;

            int rightLen = len - leftLen;
            int rightStart = leftStart + leftLen;

            mergeSort(elements, leftStart, leftLen);
            mergeSort(elements, rightStart, rightLen);

            merge(elements, leftStart, rightStart, rightLen);
        }

    }

    private void merge(
            Comparable<E>[] elements, int leftStart, int rightStart, int rightLen){
        int leftIndex = leftStart;
        int leftEnd = rightStart;
        int rightIndex = rightStart;
        int rightEnd = rightIndex + rightLen;

        int tmpIndex = 0;

        while(leftIndex < leftEnd && rightIndex < rightEnd){
             if(elements[leftIndex].compareTo((E)elements[rightIndex]) < 1){
                 incrementComparisons();
                 tmpElements[tmpIndex++] = elements[leftIndex++];
             } else {
                 incrementComparisons();
                 incrementSwaps();
                 tmpElements[tmpIndex++] = elements[rightIndex++];
             }
        }

        while(leftIndex < leftEnd){
            incrementSwaps();
            tmpElements[tmpIndex++] = elements[leftIndex++];
        }

        while(rightIndex < rightEnd){
            tmpElements[tmpIndex++] = elements[rightIndex++];
        }

        for(int i = 0; i < tmpIndex; i++){
            elements[leftStart+i] = tmpElements[i];
        }
    }
}