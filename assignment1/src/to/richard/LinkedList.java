package to.richard;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LinkedList<E> {
    protected LinkedListNode<E> head;
    protected LinkedListNode<E> tail;

    public LinkedList() {
        head = tail = null;
    }

    public LinkedListIter<LinkedListNode<E>> listIterator(){
        return new LinkedListIter<LinkedListNode<E>>(head);
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(E object){
        head = new LinkedListNode<E>(object, null, head);
        if(tail == null)
            tail = head;
    }

    public void addLast(E object){
        if(!isEmpty()){
            tail.next = new LinkedListNode<E>(object, tail, null);
            tail = tail.next;
        } else {
            head = tail = new LinkedListNode<E>(object);
        }
    }

    public void add(int pos, E object){

    }

    public E getFirst(){
        if(!isEmpty())
            return head.object;
        else
            return null;
    }

    public E getLast(){
        if(!isEmpty())
            return tail.object;
        else
            return null;
    }

    public E get(int pos){
        throw new NotImplementedException();
    }

    public boolean contains(E object){
        throw new NotImplementedException();
    }

    public int size(){
        throw new NotImplementedException();
    }

    public E removeFirst(){
        E node = head.object;
        if(head == tail)
            head = tail = null;
        else
            head = head.next;
        return node;
    }

    public E removeLast(){
        if(!isEmpty()){
            E node = tail.object;
            if(head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            return node;
        } else {
            return null;
        }
    }

    public E remove(int pos){
        throw new NotImplementedException();
    }

    public boolean remove(E object){
        throw new NotImplementedException();
    }
}