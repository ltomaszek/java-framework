package ltcode.generator;

import java.util.*;

/**
 * Generates generic values from a collection
 */
public interface Generator<T> extends Iterable<T>, Iterator<T> {

    /**
     * Returns next element
     *
     * @return next generated element T
     * @throws NoSuchElementException when iterator has no more elements
     * @throws ConcurrentModificationException when shouldCollectionBeCopied == false,
     * and in the meantime the size of the original collection will change
     */
    @Override
    public T next() throws NoSuchElementException, ConcurrentModificationException;

    /**
     * Checks if generator can generate another element
     *
     * @return true if generator has another element that it can return
     */
    @Override
    public boolean hasNext();

    /**
     * Returns an Iterator object
     *
     * @return Iterator<T>
     */
    @Override
    public Iterator<T> iterator();

    /**
     * Resets the Generator to the starting stage
     */
    public void reset();
}
