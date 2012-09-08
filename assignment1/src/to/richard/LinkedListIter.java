package to.richard;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LinkedListIter<LinkedListNode> implements Iterator<LinkedListNode> {

    private LinkedListNode node;

    public LinkedListIter(LinkedListNode node){
        this.node = node;
    }

    public boolean hasNext(){
        if(this.node.next == null)
            return false;
        else
            return true;
    }

    public LinkedListNode next(){
        if(hasNext()){
            LinkedListNode current = node;
            node = node.next;
            return node;
        } else {
            return null;
        }
    }

}
