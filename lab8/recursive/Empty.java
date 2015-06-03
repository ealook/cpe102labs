import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * Created by ethan on 5/22/15.
 */
public class Empty<T> implements Node<T> {

    public int size() {
        return 0;
    }

    @Override
    public T value() {
        throw new UnsupportedOperationException("Empty node, no value!");
    }

    @Override
    public Node<T> next() {
        throw new UnsupportedOperationException("Empty node, no next node!");
    }

    @Override
    public T get(int index, int myindex) {
        throw new IndexOutOfBoundsException("Index out of bounds!");
    }

    public Node<T> addToEnd(T val) {
        return new NotEmpty<>(val, this);
    }

    @Override
    public Node<T> add(int index, int myindex, T val) {
        if ((index - 1) == myindex) {
            return new NotEmpty<>(val, this);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
    }

    @Override
    public Node<T> remove(int index, int myindex) {
        throw new IndexOutOfBoundsException("Index out of bounds!");
    }

    @Override
    public int indexOf(T element, int myindex) {
        throw new NoSuchElementException("The element does not exist!");
    }

    @Override
    public <R> SimpleRecursiveList<R> map(Function<T, R> function) {
        return new RecursiveList<>();
    }
}
