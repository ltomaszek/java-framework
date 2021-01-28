package ltcode.generator;

import java.util.*;

/**
 * Generates randomly generic values from a collection using built-in collection's Iterator.
 * It first shuffle the collection's elements.
 * Each element in collection will be returned only exactly one time.
 */
public class RandomGenerator<T> extends BasicGenerator<T> implements Generator<T>{

    public RandomGenerator(Collection<T> collection) {
        // Collection must be cloned because of the way the Iterator works - it must shuffle the list later
        super(collection, true);
    }

    /**
     * Resets the Generator to a new random starting stage, by shuffling the collection list
     */
    @Override
    public void reset() {
        Collections.shuffle((List)collection);
        iterator = collection.iterator();
    }
}
