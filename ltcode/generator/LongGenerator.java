package ltcode.generator;

import java.util.NoSuchElementException;

/**
 * Generates long values
 */
public class LongGenerator {

    /**
     * First value to return
     */
    private final long start;

    /**
     * First value that will not be returned
     */
    private final long end;

    /**
     * Difference between two adjacent values
     */
    private final long step;

    /**
     * Current value to be returned
     */
    private long cursor;

    /**
     * Generates long values from startLongInclusive to Long.MAX_VALUE with step of 1
     */
    public LongGenerator(long startLongInclusive) {
        this(startLongInclusive, Long.MAX_VALUE);
    }

    /**
     * Generates long values from startLongInclusive to endLongExclusive with step of 1
     */
    public LongGenerator(long startLongInclusive, long endLongExclusive) {
        this(startLongInclusive, endLongExclusive, 1);
    }

    /**
     * Generates long values from startLongInclusive to endLongExclusive with step of 'step'
     */
    public LongGenerator(long startLongInclusive, long endLongExclusive, long step) {
        this.start = startLongInclusive;
        this.end = endLongExclusive;
        this.step = step;
        this.cursor = start;
    }

    /**
     * Returns next generated long value
     * @throws NoSuchElementException when generator has no more elements
     */
    public long next() throws NoSuchElementException{
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements.");
        }
        long toReturn = cursor;
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