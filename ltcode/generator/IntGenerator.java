package ltcode.generator;

import java.util.NoSuchElementException;

/**
 * Generates int values
 */
public class IntGenerator {

    /**
     * First value to return
     */
    private final int start;

    /**
     * First value that will not be returned
     */
    private final int end;

    /**
     * Difference between two adjacent values
     */
    private final int step;

    /**
     * Current value to be returned
     */
    private int cursor;

    /**
     * Generates ints from startIntInclusive to Integer.MAX_VALUE with step of 1
     */
    public IntGenerator(int startIntInclusive) {
        this(startIntInclusive, Integer.MAX_VALUE);
    }

    /**
     * Generates ints from startIntInclusive to endIntExclusive with step of 1
     */
    public IntGenerator(int startIntInclusive, int endIntExclusive) {
        this(startIntInclusive, endIntExclusive, 1);
    }

    /**
     * Generates ints from startIntInclusive to endIntExclusive with step of 'step'
     */
    public IntGenerator(int startIntInclusive, int endIntExclusive, int step) {
        this.start = startIntInclusive;
        this.end = endIntExclusive;
        this.step = step;
        this.cursor = start;
    }

    /**
     * Returns next generated int value
     *
     * @throws NoSuchElementException when generator has no more elements
     */
    public int next() throws NoSuchElementException{
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements.");
        }
        int toReturn = cursor;
        cursor += step;
        return toReturn;
    }

    /**
     * Checks if there is another element that can be generated
     *
     * @return true / false
     */
    public boolean hasNext() {
        if (step >= 0)
            return cursor < end;
        return cursor > end;
    }

    /**
     * Resets the Generator by setting current cursor to the start value
     */
    public void reset() {
        cursor = start;
    }
}