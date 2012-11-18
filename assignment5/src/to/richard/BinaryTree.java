package to.richard;

public class BinaryTree<E> {

    private BinaryNode<E> root;
    private int comparisons = 0;

    public BinaryTree(){
        root = null;
    }

    /**
     * Inserts element into tree
     * @param element
     * @return BinaryTree<E>
     */
    public BinaryTree<E> insert(Comparable<E> element){
        root = insert(element, root);
        return this;
    }

    /**
     * Inserts element into tree recursively
     * @param element
     * @param node
     * @throws IllegalArgumentException
     */
    private BinaryNode<E> insert(Comparable<E> element, BinaryNode<E> node) throws IllegalArgumentException {
        if(node == null){
            node = new BinaryNode<E>(element);
        } else if(node.value.compareTo((E)element) > 0){
            node.left = insert(element, node.left);
        } else if(node.value.compareTo((E)element) < 0){
            node.right = insert(element, node.right);
        } else {
            throw new IllegalArgumentException();
        }
        return node;
    }

    /**
     * Searches for element in tree tree
     * @param element
     * @return E
     */
    public E find(Comparable<E> element){
        comparisons = 0;
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
        } else {
            comparisons++;
            if(node.value.compareTo((E)element) > 0){
                return find(element, node.left);
            } else if(node.value.compareTo((E)element) < 0){
                return find(element, node.right);
            } else {
                return node;
            }
        }
    }

    /**
     * Test if binary tree is empty
     * @return
     */
    public boolean isEmpty(){
        return (root == null);
    }

    /**
     * Finds smallest value in tree
     *
     * Will return null if empty
     * @return E
     */
    public E findMin(){
        if(!isEmpty()){
            BinaryNode<E> node = findMin(root);
            return (E)node.value;
        } else {
            return null;
        }
    }

    /**
     * Finds smallest value recursively
     * @param node
     * @return BinaryNode<E>
     */
    private BinaryNode<E> findMin(BinaryNode<E> node){
        if(node.left == null){
            return node;
        } else {
            return findMin(node.left);
        }
    }

    /**
     * Finds largest value in tree
     *
     * Will return null if empty
     * @return E
     */
    public E findMax(){
        if(!isEmpty()){
            BinaryNode<E> node = findMax(root);
            return (E)node.value;
        } else {
            return null;
        }
    }

    /**
     * Finds largest value recursively
     * @param node
     * @return BinaryNode<E>
     */
    private BinaryNode<E> findMax(BinaryNode<E> node){
        if(node.right == null){
            return node;
        } else {
            return findMax(node.right);
        }
    }

    /**
     * Removes element from tree
     * @param element
     * @return BinaryTree<E>
     */
    public BinaryTree<E> remove(Comparable<E> element){
        root = remove(element, root);
        return this;
    }

    /**
     * Removes element from tree using recursion
     * @param element
     * @param node
     * @return BinaryNode<E>
     */
    private BinaryNode<E> remove(Comparable<E> element, BinaryNode<E> node){
        if(node == null) {
            return node;
        } else if(node.value.compareTo((E)element) > 0){
            node.left = remove(element, node.left);
            return null;
        } else if(node.value.compareTo((E)element) < 0){
            node.right = remove(element, node.right);
        } else {
            if(node.left == null && node.right == null){
                return null;
            } else if(node.left == null){
                return node.right;
            } else if(node.right == null){
                return node.left;
            } else {
                BinaryNode<E> replacement = findMin(node.right);
                remove(replacement.value, node.right);
                return replacement;
            }
        }
        return node;
    }

    /**
     * Empties tree
     * @return BinaryTree<E>
     */
    public BinaryTree<E> makeEmpty(){
        root = null;
        return this;
    }

    /**
     * Prints values of tree in order
     * @return BinaryTree<E>
     */
    public BinaryTree<E> printTree(){
        printTree(root);
        return this;
    }

    /**
     * Prints tree recursively using in order traversal
     * @param node
     */
    private void printTree(BinaryNode<E> node){
        if(node != null){
            printTree(node.left);
            System.out.print(node.value);
            System.out.print(" ");
            printTree(node.right);
        }
    }

    /**
     * Gets comparisons for find method
     * @return int
     */
    public int getComparisons(){
        return comparisons;
    }
}
