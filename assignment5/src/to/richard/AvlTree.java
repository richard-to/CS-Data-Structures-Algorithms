package to.richard;

public class AvlTree<E> {

    private AvlNode<E> root;
    private int comparisons = 0;

    public AvlTree(){
        root = null;
    }

    /**
     * Inserts element into tree
     * @param element
     * @return AvlTree<E>
     */
    public AvlTree<E> insert(Comparable<E> element){
        root = insert(element, root);
        return this;
    }

    /**
     * Inserts element into tree recursively
     * @param element
     * @param node
     * @throws IllegalArgumentException
     */
    private AvlNode<E> insert(Comparable<E> element, AvlNode<E> node) throws IllegalArgumentException {
        if(node == null){
            node = new AvlNode<E>(element);
        } else if(node.value.compareTo((E)element) > 0){
            node.left = insert(element, node.left);
            if(height(node.left) - height(node.right) > 1){
                if(element.compareTo((E)node.left.value) < 0){
                    node = rotateWithLeftChild(node);
                } else {
                    node = doubleWithLeftChild(node);
                }
            }
        } else if(node.value.compareTo((E)element) < 0){
            node.right = insert(element, node.right);
            if(height(node.left) - height(node.right) < -1){
                if(element.compareTo((E)node.right.value) > 0){
                    node = rotateWithRightChild(node);
                } else {
                    node = doubleWithRightChild(node);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        node.height = max(height(node.left), height(node.right));
        return node;
    }

    /**
     * Searches for element in tree tree
     * @param element
     * @return E
     */
    public E find(Comparable<E> element){
        comparisons = 0;
        AvlNode<E> node = find(element, root);
        return (node != null) ? (E)node.value : null;
    }

    /**
     * Finds node in tree that equals element value
     * @param element
     * @param node
     * @return AvlNode<E>
     */
    private AvlNode<E> find(Comparable<E> element, AvlNode<E> node){
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
     * Removes element from tree
     * @param element
     * @return AvlTree<E>
     */
    public AvlTree<E> remove(Comparable<E> element){
        root = remove(element, root);
        return this;
    }

    /**
     * Removes element from tree recursively
     * @param element
     * @param node
     * @return AvlNode<E>
     */
    private AvlNode<E> remove(Comparable<E> element, AvlNode<E> node){
        if(node == null) {
            return node;
        } else if(node.value.compareTo((E)element) > 0){
            node.left = remove(element, node.left);
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
                AvlNode<E> replacement = findMax(node.left);
                replacement.left = remove(replacement.value, node.left);
                replacement.right = node.right;
                return replacement;
            }
        }

        if(height(node.left) - height(node.right) > 1){
            if(height(node.left.left) > height(node.left.right)){
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if(height(node.left) - height(node.right) < -1){
            if(height(node.right.right) > height(node.right.left)){
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }
        }
        node.height = max(height(node.left), height(node.right)) + 1;
        return node;
    }

    /**
     * Calculates height of subtree
     * @param node
     * @return int
     */
    private int height(AvlNode<E> node){
        if(node == null){
            return 0;
        } else {
            return max(height(node.left), height(node.right)) + 1;
        }
    }

    /**
     * Gets max height of left right subtrees
     * @param lhs
     * @param rhs
     * @return int
     */
    private int max(int lhs, int rhs){
        if(lhs > rhs){
            return lhs;
        } else {
            return rhs;
        }
    }

    /**
     * Handles case 1: Left of root with left subtree imbalance
     * @param k1
     * @return AvlNode<E>
     */
    private AvlNode<E> rotateWithLeftChild(AvlNode<E> k1){
        AvlNode<E> k2 = k1.left;
        k1.left = k2.right;
        k2.right = k1;
        k1.height = max(height(k1.left), height(k2.right)) + 1;
        k2.height = max(height(k2.left), k1.height) + 1;
        return k2;
    }

    /**
     * Handles case 4: Right of root with right subtree imbalance
     * @param k1
     * @return AvlNode<E>
     */
    private AvlNode<E> rotateWithRightChild(AvlNode<E> k1){
        AvlNode<E> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k2.right)) + 1;
        k2.height = max(k1.height, height(k2.right)) + 1;
        return k2;
    }

    /**
     * Handles case 2: Left of root with right subtree imbalance
     * @param k1
     * @return AvlNode<E>
     */
    private AvlNode<E> doubleWithLeftChild(AvlNode<E> k1){
        k1.left = rotateWithRightChild(k1.left);
        return rotateWithLeftChild(k1);
    }

    /**
     * Handles case 3: Right of root with left subtree imbalance
     * @param k1
     * @return AvlNode<E>
     */
    private AvlNode<E> doubleWithRightChild(AvlNode<E> k1){
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    /**
     * Tests if binary tree is empty
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
            AvlNode<E> node = findMin(root);
            return (E)node.value;
        } else {
            return null;
        }
    }

    /**
     * Finds smallest value recursively
     * @param node
     * @return AvlNode<E>
     */
    private AvlNode<E> findMin(AvlNode<E> node){
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
            AvlNode<E> node = findMax(root);
            return (E)node.value;
        } else {
            return null;
        }
    }

    /**
     * Finds largest value recursively
     * @param node
     * @return AvlNode<E>
     */
    private AvlNode<E> findMax(AvlNode<E> node){
        if(node.right == null){
            return node;
        } else {
            return findMax(node.right);
        }
    }

    /**
     * Removes element from tree
     * @param element
     * @return AvlTree<E>
     */
    /*public AvlTree<E> remove(Comparable<E> element){
        root = remove(element, root);
        return this;
    }*/

    /**
     * Empties tree
     * @return AvlTree<E>
     */
    public AvlTree<E> makeEmpty(){
        root = null;
        return this;
    }

    /**
     * Prints values of tree in order
     * @return AvlTree<E>
     */
    public AvlTree<E> printTree(){
        printTree(root);
        return this;
    }

    /**
     * Prints tree recursively using in order traversal
     * @param node
     */
    private void printTree(AvlNode<E> node){
        if(node != null){
            printTree(node.left);
            System.out.print(node.value);
            System.out.print(" ");
            printTree(node.right);
        }
    }

    /**
     * Prints values of tree in order by level starting at root
     * @return AvlTree<E>
     */
    public AvlTree<E> printTreeLevel(){
        printTreeLevel(root);
        return this;
    }

    /**
     * Prints tree  using breadth first
     * @param node
     */
    private void printTreeLevel(AvlNode<E> node){
        if(node == null){
            System.out.print("");
            return;
        }
        Queue<AvlNode<E>> queue = new Queue<AvlNode<E>>();
        queue.enqueue(node);
        while(!queue.isEmpty()){
            AvlNode<E> currentNode = queue.dequeue();

            System.out.print(currentNode.value);
            System.out.print(" ");

            if(currentNode.left != null)
                queue.enqueue(currentNode.left);
            if(currentNode.right != null)
                queue.enqueue(currentNode.right);
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
