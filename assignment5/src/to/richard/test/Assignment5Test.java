package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import to.richard.MockNumGen;
import to.richard.Queue;

public class Assignment5Test {
    @Test
    public void testNumGenUnique() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(5).enqueue(8).enqueue(5).enqueue(3).enqueue(9).enqueue(8).enqueue(10);
        MockNumGen numGen = new MockNumGen(10, 5, true, queue);
        int[] sequence = numGen.generate();
        int[] expected = new int[]{5,8,3,9,10};
        assertArrayEquals(expected, sequence);
    }

    @Test
    public void testNumGenNonUnique() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(5).enqueue(8).enqueue(5).enqueue(3).enqueue(9).enqueue(8).enqueue(10);
        MockNumGen numGen = new MockNumGen(10, 5, false, queue);
        int[] sequence = numGen.generate();
        int[] expected = new int[]{5,8,5,3,9};
        assertArrayEquals(expected, sequence);
    }
}
