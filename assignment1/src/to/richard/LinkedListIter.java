package to.richard;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LinkedListIter<E> implements Iterator<E> {

    private LinkedListNode<E> node;

    public LinkedListIter(LinkedListNode<E> node){
        this.node = node;
    }

    public boolean hasNext(){
        if(this.node == null)
            return false;
        else
            return true;
    }

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
