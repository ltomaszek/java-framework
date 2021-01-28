package ltcode.generator;

import java.util.*;

/**
 * Generates generic values from a collection from first element to last using built-in collection's Iterator.
 * Each element in collection will be returned only exactly one time.
 */
public class BasicGenerator<T> implements Generator<T>, Iterable<T>, Iterator<T> {

    /**
     * The collection we are iterating over
     */
    protected Collection<T> collection;

    /**
     * The collection's iterator
     */
    protected Iterator<T> iterator;

    public BasicGenerator(Collection<T> collection) {
        this(collection, false);
    }

    public BasicGenerator(Collection<T> collection, boolean shouldCollectionBeCopied) {
        if (shouldCollectionBeCopied) {
            this.collection = new ArrayList<T>(collection);
        } else {
            this.collection = collection;
        }
        // Create iterator
        this.reset();
    }

    /**
     * Returns next element in collection
     *
     * @return next generated element T
     * @throws NoSuchElementException when iterator has no more elements
     * @throws ConcurrentModificationException when shouldCollectionBeCopied == false,
     * and in the meantime the size of the original collection will change
     */
    @Override
    public T next() throws NoSuchElementException, ConcurrentModificationException {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * Returns always the same Iterator object. If new Iterator is needed use the function reset()
     *
     * @return Iterator<T> we created in reset()
     */
    @Override
    public Iterator<T> iterator() {
        return iterator;
    }

    /**
     * Resets the Generator to the starting stage
     */
    public void reset() {
        iterator = collection.iterator();
    }
}