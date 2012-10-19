package to.richard;

/**
 * Generic Queue Data structure that uses
 * double linked list internally
 * @param <E>
 */
public class Queue<E> {

    private LinkedList<E> list;

    public Queue() {
        list = new LinkedList<E>();
    }

    /**
     * Checks if queue is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds object to queue
     * @param <E> object
     * @return Queue<E>
     */
    public Queue<E> enqueue(E object) {
        list.addFirst(object);
        return this;
    }

    /**
     * Gets oldest object from queue and removes
     * @return <E> object
     */
    public E dequeue(){
        return list.removeLast();
    }

    /**
     * Removes all objects from queue
     * @return Queue<E>
     */
    public Queue<E> makeEmpty() {
        list = new LinkedList<E>();
        return this;
    }
}
