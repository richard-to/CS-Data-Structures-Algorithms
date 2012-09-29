package to.richard;

/**
 * Generic stack implementation
 *
 * @param <E>
 */
public class Stack<E> {

    StackNode<E> top;

    public Stack(){
        top = null;
    }

    /**
     * Checks if stack is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return (top == null);
    }

    /**
     * Adds object to top of stack
     * @param object
     * @return Stack<E>
     */
    public Stack<E> push(E object){
        StackNode<E> node = new StackNode<E>(object, top);
        top = node;
        return this;
    }

    /**
     * Gets top object of stack
     * @return object
     */
    public E top(){
        if(!isEmpty())
            return top.object;
        else
            return null;
    }

    /**
     * Removes top object from stack
     * @return Stack<E>
     */
    public Stack<E> pop(){

    }
}
