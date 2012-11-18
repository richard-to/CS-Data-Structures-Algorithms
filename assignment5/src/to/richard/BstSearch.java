package to.richard;

/**
 * Find element using binary search tree
 */
public class BstSearch<E> extends Search<E> {
    BinaryTree<E> bst;

    /**
     * Constructor
     * @param sequence Array of elements in any order
     */
    public BstSearch(Comparable<E>[] sequence){
        this.bst = new BinaryTree<E>();
        for(int i = 0; i < sequence.length; i++){
            this.bst.insert(sequence[i]);
        }
    }

    /**
     * Finds element using bst
     * Returns null if not found
     * @param element
     * @return E
     */
    public E find(Comparable<E> element){
        E foundElement = bst.find(element);
        setComparisons(bst.getComparisons());
        return foundElement;
    }
}
