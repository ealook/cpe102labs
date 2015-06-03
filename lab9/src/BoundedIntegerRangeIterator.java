import java.util.Iterator;

/**
 * Created by ethan on 6/1/15.
 */
public class BoundedIntegerRangeIterator implements Iterator<Integer>, Iterable<Integer> {

    private Integer cur;
    private Integer max;

    public BoundedIntegerRangeIterator(Integer min, Integer max) {
        this.cur = min;
        this.max = max;
    }

    @Override
    public boolean hasNext() {
        return !(cur == max);
    }

    @Override
    public Integer next() {
        Integer value = cur;
        cur = cur + 1;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }
}
