package to.richard;

/**
 * Generic stack node
 *
 * @param <E>
 */
public class StackNode<E> {
    public E object;
    public StackNode<E> next;

    public StackNode(E object){
        this(object, null);
    }

    public StackNode(E object, StackNode<E> next){
        this.object = object;
        this.next = next;
    }
}
