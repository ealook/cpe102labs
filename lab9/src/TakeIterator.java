import java.util.Iterator;

/**
 * Created by ethan on 6/1/15.
 */
public class TakeIterator<T> implements Iterator<T>, Iterable<T> {

    private int count;
    private int numToTake;
    private Iterator<T> iter;

    public TakeIterator(int numToTake, Iterator<T> iter) {
        this.count = 0;
        this.numToTake = numToTake;
        this.iter = iter;
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return count != numToTake && iter.hasNext();
    }

    @Override
    public T next() {
        T value = iter.next();
        count++;
        return value;
    }
}
