package to.richard;

public class BinaryNode<E> {
    public BinaryNode left;
    public BinaryNode right;
    public Comparable<E> value;

    public BinaryNode(Comparable<E> value){
        this(value, null, null);
    }

    public BinaryNode(Comparable<E> value, BinaryNode left, BinaryNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
