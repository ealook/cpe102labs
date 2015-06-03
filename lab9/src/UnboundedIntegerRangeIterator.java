import java.util.Iterator;

/**
 * Created by ethan on 6/1/15.
 */
public class UnboundedIntegerRangeIterator implements Iterator<Integer>, Iterable<Integer> {

    private Integer cur;

    public UnboundedIntegerRangeIterator(Integer min) {
        this.cur = min;
    }

    @Override
    public boolean hasNext() {
        return !(cur == Integer.MAX_VALUE);
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
