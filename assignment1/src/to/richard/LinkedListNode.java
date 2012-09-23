package to.richard;

/**
 * Generic Double LinkedList Node
 *
 * @param <E>
 */
public class LinkedListNode<E> {
    public E object;
    public LinkedListNode<E> prev;
    public LinkedListNode<E> next;

    public LinkedListNode(E node) {
        this(node, null, null);
    }

    public LinkedListNode(E object, LinkedListNode<E> prev, LinkedListNode<E> next) {
        this.next = next;
        this.prev = prev;
        this.object = object;
    }
}
