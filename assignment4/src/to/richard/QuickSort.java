package to.richard;

/**
 * Generic Quicksort implementation
 */
public class QuickSort<E> implements ISort<E> {

    /**
     * Sorts array using Quick sort
     * @param elements Array of elements implementing comparable
     * @return E[]
     */
    public E[] sort(Comparable<E>[] elements){
        quicksort(elements, 0, elements.length-1);
        return (E[])elements;
    }

    private void quicksort(Comparable<E>[] elements, int left, int right) {
        if(left >= right){
            return;
        }

        int mid = left + (right - left)/ 2;
        int pivot = right;
        if(elements[left].compareTo((E)elements[right]) > -1){
            if(elements[left].compareTo((E)elements[mid]) < 1){
                pivot = left;
            } else if(elements[mid].compareTo((E)elements[right]) < 1){
                pivot = mid;
            }
        } else if(elements[mid].compareTo((E)elements[right]) > -1) {
            if(elements[mid].compareTo((E)elements[left]) < 1){
                pivot = mid;
            } else if(elements[left].compareTo((E)elements[right]) < 1){
                pivot = left;
            }
        }

        int newPivot = partition(elements, left, right, pivot);

        quicksort(elements, left, newPivot - 1);
        quicksort(elements, newPivot + 1, right);
    }

    private int partition(Comparable<E>[] elements, int left, int right, int pivot){
        Comparable<E> pivotValue = elements[pivot];
        swap(elements, pivot, right);
        int storeIndex = left;

        for(int i = left; i < right; i++){
            if(elements[i].compareTo((E)pivotValue) < 1) {
                swap(elements, i, storeIndex);
                storeIndex++;
            }
        }
        swap(elements, storeIndex, right);
        return storeIndex;
    }

    private void swap(Comparable<E>[] elements, int a, int b) {
        Comparable<E> tmp = elements[b];
        elements[b] = elements[a];
        elements[a] = tmp;
    }
}
