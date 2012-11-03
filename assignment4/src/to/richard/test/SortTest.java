package to.richard.test;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import to.richard.SelectionSort;
import to.richard.InsertionSort;
import to.richard.MergeSort;

public class SortTest {

    @Test
    public void testSelectionSort0() {
        String[] elements = new String[]{};
        String[] expected = new String[]{};
        SelectionSort<String> sorter = new SelectionSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testSelectionSort1() {
        String[] elements = new String[]{"B"};
        String[] expected = new String[]{"B"};
        SelectionSort<String> sorter = new SelectionSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testSelectionSort5() {
        String[] elements = new String[]{"B", "C", "A", "Z", "G"};
        String[] expected = new String[]{"A", "B", "C", "G", "Z"};
        SelectionSort<String> sorter = new SelectionSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testSelectionSortReverse() {
        String[] elements = new String[]{"Z", "R", "G", "A", "A"};
        String[] expected = new String[]{"A", "A", "G", "R", "Z"};
        SelectionSort<String> sorter = new SelectionSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testInsertionSort0() {
        String[] elements = new String[]{};
        String[] expected = new String[]{};
        InsertionSort<String> sorter = new InsertionSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testInsertionSort1() {
        String[] elements = new String[]{"B"};
        String[] expected = new String[]{"B"};
        InsertionSort<String> sorter = new InsertionSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testInsertionSort5() {
        String[] elements = new String[]{"B", "C", "A", "Z", "G"};
        String[] expected = new String[]{"A", "B", "C", "G", "Z"};
        InsertionSort<String> sorter = new InsertionSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testInsertionSortReverse() {
        String[] elements = new String[]{"Z", "R", "G", "A", "A"};
        String[] expected = new String[]{"A", "A", "G", "R", "Z"};
        InsertionSort<String> sorter = new InsertionSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testMergeSort0() {
        String[] elements = new String[]{};
        String[] expected = new String[]{};
        MergeSort<String> sorter = new MergeSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testMergeSort1() {
        String[] elements = new String[]{"B"};
        String[] expected = new String[]{"B"};
        MergeSort<String> sorter = new MergeSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testMergeSort5() {
        String[] elements = new String[]{"B", "C", "A", "Z", "G"};
        String[] expected = new String[]{"A", "B", "C", "G", "Z"};
        MergeSort<String> sorter = new MergeSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testMergeSortReverse() {
        String[] elements = new String[]{"Z", "R", "G", "A", "A"};
        String[] expected = new String[]{"A", "A", "G", "R", "Z"};
        MergeSort<String> sorter = new MergeSort<String>();
        String[] sorted = sorter.sort(elements);
        assertArrayEquals(expected, sorted);
    }    
}
