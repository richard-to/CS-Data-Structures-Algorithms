package to.richard.test;

import org.junit.Test;
import to.richard.Queue;

import static org.junit.Assert.assertEquals;

public class QueueTest {

    @Test
    public void testEnqueueAndDequeue() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        assertEquals(new Integer(1), queue.dequeue());
    }

    @Test
    public void testDequeue() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1).enqueue(2);
        assertEquals(new Integer(1), queue.dequeue());
        assertEquals(new Integer(2), queue.dequeue());
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<Integer>();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testIsEmptyNot() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void testMakeEmpty() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1).enqueue(2).enqueue(3).makeEmpty();
        assertEquals(true, queue.isEmpty());
    }
}
