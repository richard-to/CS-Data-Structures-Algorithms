package to.richard;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LinkedList<E> {
    private LinkedListNode<E> head;
    private LinkedListNode<E> tail;
    private int count;

    public LinkedList() {
        head = tail = null;
        count = 0;
    }

    public LinkedListIter<E> iterator(){
        return new LinkedListIter<E>(head);
    }

    public InternalIter<E> nodeIterator(){
        return new InternalIter<E>(head);
    }

    public boolean isEmpty(){
        return head == null;
    }

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

    public LinkedList<E> add(E object) {
        return addFirst(object);
    }

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

    public int size(){
        return count;
    }

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

class InternalIter<E> implements Iterator<LinkedListNode<E>> {

    private LinkedListNode<E> node;

    public InternalIter(LinkedListNode<E> node){
        this.node = node;
    }

    public boolean hasNext(){
        if(this.node == null)
            return false;
        else
            return true;
    }

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
