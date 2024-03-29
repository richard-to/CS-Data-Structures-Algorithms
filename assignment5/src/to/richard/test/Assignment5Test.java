package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import to.richard.*;

public class Assignment5Test {

    @Test
    public void testNumGenUnique() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(5).enqueue(8).enqueue(5).enqueue(3).enqueue(9).enqueue(8).enqueue(10);
        MockNumGen numGen = new MockNumGen(10, 5, true, queue);
        Integer[] sequence = numGen.generate();
        Integer[] expected = new Integer[]{5,8,3,9,10};
        assertArrayEquals(expected, sequence);
    }

    @Test
    public void testNumGenNonUnique() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(5).enqueue(8).enqueue(5).enqueue(3).enqueue(9).enqueue(8).enqueue(10);
        MockNumGen numGen = new MockNumGen(10, 5, false, queue);
        Integer[] sequence = numGen.generate();
        Integer[] expected = new Integer[]{5,8,5,3,9};
        assertArrayEquals(expected, sequence);
    }

    @Test
    public void testMax(){
        NumGen numGen = new NumGen(2000, 20, true);
        Integer[] randSeq = numGen.generate();
        assertEquals(20, randSeq.length);
    }

    @Test
    public void testLinearSearch(){
        Integer[] seq = {233, 23, 78, 34, 80, 822, 2};
        LinearSearch<Integer> search = new LinearSearch<Integer>(seq);
        for(int i = 0; i < seq.length; i++){
            assertEquals(seq[i], search.find(seq[i]));
        }
        search.find(2);
        assertEquals(new Integer(7), new Integer(search.getComparisons()));
        assertEquals(null, search.find(new Integer(755)));
    }

    @Test
    public void testBinarySearch(){
        Integer[] seq = {233, 23, 78, 34, 80, 822, 2};
        BinarySearch<Integer> search = new BinarySearch<Integer>(seq);
        for(int i = 0; i < seq.length; i++){
            assertEquals(seq[i], search.find(seq[i]));
        }
        search.find(2);
        assertEquals(new Integer(3), new Integer(search.getComparisons()));
        assertEquals(null, search.find(new Integer(755)));
    }

    @Test
    public void testBstSearch(){
        Integer[] seq = {233, 23, 78, 34, 80, 822, 2};
        BstSearch<Integer> search = new BstSearch<Integer>(seq);
        for(int i = 0; i < seq.length; i++){
            assertEquals(seq[i], search.find(seq[i]));
        }
        search.find(2);
        assertEquals(new Integer(3), new Integer(search.getComparisons()));
        assertEquals(null, search.find(new Integer(755)));
    }

    @Test
    public void testAvlSearch(){
        Integer[] seq = {233, 23, 78, 34, 80, 822, 2};
        AvlSearch<Integer> search = new AvlSearch<Integer>(seq);
        for(int i = 0; i < seq.length; i++){
            assertEquals(seq[i], search.find(seq[i]));
        }
        search.find(2);
        assertEquals(new Integer(3), new Integer(search.getComparisons()));
        assertEquals(null, search.find(new Integer(755)));
        assertEquals(null, search.find(new Integer(755)));
    }

    @Test
    public void testCompMon(){
        Integer[] seq = {233, 23, 78, 34, 80, 822, 2};
        LinearSearch<Integer> search = new LinearSearch<Integer>(seq);
        CompMon<Integer> compMon = new CompMon<Integer>(search);
        compMon.run();
        assertEquals(new Integer(7), new Integer(compMon.getRuns()));
        assertEquals(new Integer(28), new Integer(compMon.getTotal()));
        assertEquals(new Integer(1), new Integer(compMon.getMin()));
        assertEquals(new Integer(7), new Integer(compMon.getMax()));
        assertEquals(4, compMon.getAvg(), 0.0);
    }
}
