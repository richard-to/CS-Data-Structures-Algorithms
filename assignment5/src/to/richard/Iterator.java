package to.richard;

/**
 * Customer iterator interface
 *
 * Does not implement remove method.
 *
 * @param <E>
 */
public interface Iterator<E> {
    public boolean hasNext();
    public E next();
}