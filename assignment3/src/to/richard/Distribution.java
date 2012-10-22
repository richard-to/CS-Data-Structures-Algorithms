package to.richard;

import java.util.TreeMap;

/**
 * Randomly distributes values based on probabilities
 * @param <E>
 */
public class Distribution<E> {

    private TreeMap<Double, E> map;

    public Distribution() {
        map = new TreeMap<Double, E>();
    }

    /**
     * Adds distribution ceiling point and value pair
     *
     * Note that this does not check if a distribution point
     * greater than 1.0 is entered.
     *
     * @param ceiling A value that will be the exclusive data point
     * @param value
     * @return Distribution<E>
     */
    public Distribution<E> add(double ceiling, E value) {
        map.put(ceiling, value);
        return this;
    }

    /**
     * Gets value within distribution point
     * @param point
     * @return E
     */
    public E get(double point){
        Double key = map.lowerKey(point);
        E value = map.get(key);
        return value;
    }
}

