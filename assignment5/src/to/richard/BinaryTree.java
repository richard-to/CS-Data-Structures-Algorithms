package to.richard;

public class BinaryTree<E> {

    private BinaryNode<E> root;

    public BinaryTree(){
        root = null;
    }

    /**
     * Inserts element into tree
     * @param element
     * @return BinaryTree<E>
     */
    public BinaryTree<E> insert(Comparable<E> element){
        if(root == null){
            root = new BinaryNode<E>(element);
        } else {
            insert(element, root);
        }
        return this;
    }

    /**
     * Inserts element into tree recursively
     * @param element
     * @param node
     * @throws IllegalArgumentException
     */
    private void insert(Comparable<E> element, BinaryNode<E> node) throws IllegalArgumentException {
        if(node.value.compareTo((E)element) > 0){
            if(node.left != null){
                insert(element, node.left);
            } else {
                node.left = new BinaryNode<E>(element);
            }
        } else if(node.value.compareTo((E)element) < 0){
            if(node.right != null){
                insert(element, node.right);
            } else {
                node.right = new BinaryNode<E>(element);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Searches for element in tree tree
     * @param element
     * @return E
     */
    public E find(Comparable<E> element){
        BinaryNode<E> node = find(element, root);
        return (node != null) ? (E)node.value : null;
    }

    /**
     * Finds node in tree that equals element value
     * @param element
     * @param node
     * @return BinaryNode<E>
     */
    private BinaryNode<E> find(Comparable<E> element, BinaryNode<E> node){
        if(node == null) {
            return null;
        } else if(node.value.compareTo((E)element) > 0){
            return find(element, node.left);
        } else if(node.value.compareTo((E)element) < 0){
            return find(element, node.right);
        } else {
            return node;
        }
    }

    /**
     * Test if binary tree is empty
     * @return
     */
    public boolean isEmpty(){
        return (root == null);
    }

    /*
    public BinaryTree<E> remove(E element){

    }

    public E findMin(){

    }

    public E findMax(){

    }

    public void makeEmpty(){

    }

    */
    public void printTree(){

    }
}
