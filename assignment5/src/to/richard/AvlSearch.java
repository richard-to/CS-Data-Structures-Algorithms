package to.richard;

/**
 * Find element using avl tree
 */
public class AvlSearch<E> extends Search<E> {
    AvlTree<E> avl;

    /**
     * Constructor
     * @param sequence Array of elements in any order
     */
    public AvlSearch(Comparable<E>[] sequence){
        this.sequence = sequence;
        this.avl = new AvlTree<E>();
        for(int i = 0; i < sequence.length; i++){
            this.avl.insert(sequence[i]);
        }
    }

    /**
     * Finds element using avl tree
     * Returns null if not found
     * @param element
     * @return E
     */
    public E find(Comparable<E> element){
        E foundElement = avl.find(element);
        setComparisons(avl.getComparisons());
        return foundElement;
    }
}
