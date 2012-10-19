package to.richard;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Generic double-linked list
 *
 * @param <E>
 */
public class LinkedList<E> {
    private LinkedListNode<E> head;
    private LinkedListNode<E> tail;
    private int count;

    public LinkedList() {
        head = tail = null;
        count = 0;
    }

    /**
     * Gets iterator
     *
     * @return LinkedListIter<E>
     */
    public LinkedListIter<E> iterator(){
        return new LinkedListIter<E>(head);
    }

    /**
     * Gets node iterator
     *
     * Used internally for cases where the actual
     * node is needed.
     *
     * @return InternalIter<E>
     */
    protected InternalIter<E> nodeIterator(){
        return new InternalIter<E>(head);
    }

    /**
     * Checks if list is empty
     *
     * @return boolean true|fasle if empty
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Adds object to front of list
     *
     * @param object
     * @return LinkedList<E>
     */
    public LinkedList<E> addFirst(E object){
        if(!isEmpty()){
            head.prev = new LinkedListNode<E>(object, null, head);
            head = head.prev;
        } else {
            head = tail = new LinkedListNode<E>(object);
        }
        ++count;
        return this;
    }

    /**
     * Adds object to end of list
     *
     * @param object
     * @return LinkedList<E>
     */
    public LinkedList<E> addLast(E object){
        if(!isEmpty()){
            tail.next = new LinkedListNode<E>(object, tail, null);
            tail = tail.next;
        } else {
            head = tail = new LinkedListNode<E>(object);
        }
        ++count;
        return this;
    }

    /**
     * Adds object to front of list
     *
     * @param object
     * @return LinkedList<E>
     */
    public LinkedList<E> add(E object) {
        return addFirst(object);
    }

    /**
     * Adds object to specific index in list
     *
     * If the index is equals the size of the list, then
     * add it to the end of the list.
     *
     * @param object
     * @return LinkedList<E>
     * @throws IndexOutOfBoundsException
     */
    public LinkedList<E> add(int pos, E object) throws IndexOutOfBoundsException {
        if(pos == 0){
            return addFirst(object);
        } else if(pos == size()) {
            return addLast(object);
        } if(!isEmpty()){
            InternalIter<E> iter = nodeIterator();
            int curPos = 0;
            LinkedListNode<E> prev = null;
            LinkedListNode<E> current = null;
            while(iter.hasNext()){
                prev = current;
                current = iter.next();
                if(curPos == pos){
                    LinkedListNode<E> newNode = new LinkedListNode<E>(object, prev, current);
                    prev.next = newNode;
                    current.prev = newNode;
                    ++count;
                    return this;
                }
                ++curPos;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Gets first object in list
     *
     * @return E|null Null if empty list
     */
    public E getFirst(){
        if(!isEmpty())
            return head.object;
        else
            return null;
    }

    /**
     * Gets last object in list
     *
     * @return E|null Null if empty list
     */
    public E getLast(){
        if(!isEmpty())
            return tail.object;
        else
            return null;
    }

    /**
     * Gets object at specific index
     *
     * @param pos
     * @return E
     * @throws IndexOutOfBoundsException
     */
    public E get(int pos) throws IndexOutOfBoundsException {
        if(!isEmpty()){
            LinkedListIter<E> iter = iterator();
            int curPos = 0;
            while(iter.hasNext()){
                E object = iter.next();
                if(curPos == pos){
                    return object;
                }
                ++curPos;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Checks if object E exists in list
     *
     * @param object
     * @return boolean true|false
     */
    public boolean contains(E object){
        if(!isEmpty()){
            LinkedListIter<E> iter = iterator();
            while(iter.hasNext()){
                if(object.equals(iter.next())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets size of list
     *
     * @return int
     */
    public int size(){
        return count;
    }

    /**
     * Removes first E from list
     *
     * @return E
     */
    public E removeFirst(){
        if(!isEmpty()){
            E node = head.object;
            if(head == tail)
                head = tail = null;
            else
                head = head.next;
            --count;
            return node;
        } else {
            return null;
        }
    }

    /**
     * Removes last element from lst
     *
     * @return E
     */
    public E removeLast(){
        if(!isEmpty()){
            E node = tail.object;
            if(head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            --count;
            return node;
        } else {
            return null;
        }
    }

    /**
     * Removes element at index
     *
     * @param pos
     * @return E
     * @throws IndexOutOfBoundsException
     */
    public E remove(int pos) throws IndexOutOfBoundsException{
        if(!isEmpty()){
            if(pos == 0){
                return removeFirst();
            } else {
                InternalIter<E> iter = nodeIterator();
                int curPos = 0;
                LinkedListNode<E> prev = null;
                LinkedListNode<E> current = null;
                while(iter.hasNext()){
                    prev = current;
                    current = iter.next();
                    if(curPos == pos){
                        LinkedListNode<E> next = iter.next();
                        if(prev == null){
                            removeFirst();
                        } else if(next == null) {
                            removeLast();
                        } else {
                            prev.next = next;
                            next.prev = prev;
                            --count;
                        }
                        return current.object;
                    }
                    ++curPos;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Removes object from list
     *
     * Uses equals operator to determine equality
     *
     * @param object
     * @return boolean true|false
     */
    public boolean remove(E object){
        if(!isEmpty()){
            InternalIter<E> iter = nodeIterator();
            LinkedListNode<E> prev = null;
            LinkedListNode<E> current = null;
            while(iter.hasNext()){
                prev = current;
                current = iter.next();
                if(object.equals(current.object)){
                    LinkedListNode<E> next = iter.next();

                    if(prev == null){
                        removeFirst();
                    } else if(next == null) {
                        removeLast();
                    } else {
                        prev.next = next;
                        next.prev = prev;
                        --count;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Internal iterator class used by double linked list
 * @param <E>
 */
class InternalIter<E> implements Iterator<LinkedListNode<E>> {

    private LinkedListNode<E> node;

    public InternalIter(LinkedListNode<E> node){
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
     * @return LinkedListNode<E>|null
     */
    public LinkedListNode<E> next(){
        if(hasNext()){
            LinkedListNode<E> current = node;
            node = node.next;
            return current;
        } else {
            return null;
        }
    }
}
