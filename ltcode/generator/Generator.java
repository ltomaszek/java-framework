package ltcode.generator;

import java.util.*;

/**
 * Generates generic values from a collection from first element to last
 * using built-in collection's Iterator
 */
public class Generator<T> implements Iterable<T>, Iterator<T> {

    /**
     * The collection we are iterating over
     */
    private Collection<T> collection;

    /**
     * The collection's iterator
     */
    private Iterator<T> iterator;

    public Generator(Collection<T> collection) {
        this(collection, false);
    }

    public Generator(Collection<T> collection, boolean shouldCollectionBeCopied) {
        if (shouldCollectionBeCopied) {
            this.collection = new ArrayList<T>(collection);
        } else {
            this.collection = collection;
        }
        this.iterator = this.collection.iterator();
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
