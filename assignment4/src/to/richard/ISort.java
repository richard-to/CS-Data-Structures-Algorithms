package to.richard;

/**
 * Basic sort interface using default sort order
 * @param <E>
 */
public interface ISort<E> {
    public E[] sort(Comparable<E>[] elements);
}
