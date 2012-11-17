package to.richard;

public class AvlNode<E> {
    public Comparable<E> value;
    public AvlNode<E> left;
    public AvlNode<E> right;
    public int height;

    public AvlNode(Comparable<E> value){
        this(value, null,null);
    }

    public AvlNode(Comparable<E> value, AvlNode<E> left, AvlNode<E> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
