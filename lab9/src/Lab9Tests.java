import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.util.NoSuchElementException;

public class Lab9Tests {

    private static final double DELTA = 0.00001;

    @Test
    public void testBoundedIntegerRangeIterator() {
        int index = 0;
        for (Integer i : new BoundedIntegerRangeIterator(0, 10)) {
            System.out.println(i);
            assertEquals(index, i, DELTA);
            index++;
        }
    }

    @Test
    public void testUnboundedIntegerRangeIterator() {
        UnboundedIntegerRangeIterator iterator = new UnboundedIntegerRangeIterator(1);

        int index = 0;
        while (index < 1024) {

            assertTrue(iterator.hasNext());
            assertEquals(index + 1, iterator.next(), DELTA);

            index++;
        }
    }

    @Test
    public void testTakeIterator() {
        int index = 1;
        for (Integer i : new TakeIterator<>(10, new UnboundedIntegerRangeIterator(1))) {
            System.out.println(i);
            assertEquals(index, i, DELTA);
            index++;
        }
    }


}