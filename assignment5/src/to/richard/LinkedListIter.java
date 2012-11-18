package to.richard;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * LinkedList Iterator implementation
 *
 * Does not implement remove method.
 *
 * @param <E>
 */
public class LinkedListIter<E> implements Iterator<E> {

    private LinkedListNode<E> node;

    public LinkedListIter(LinkedListNode<E> node){
        this.node = node;
    }

    /**
     * Checks if another node exists in list
     * @return boolean true|false if next node exists
     */
    public boolean hasNext(){
        if(this.node == null)
            return false;
        else
            return true;
    }

    /**
     * Gets next node
     *
     * If no next node, then return null, otherwise return element.
     *
     * This method will set the next node in the list after returning
     * the current node.
     *
     * @return E|null
     */
    public E next(){
        if(hasNext()){
            LinkedListNode<E> current = node;
            node = node.next;
            return current.object;
        } else {
            return null;
        }
    }

}