import java.util.function.Function;

/**
 * Created by ethan on 5/22/15.
 */
public class NotEmpty<T> implements Node<T> {

    private T element;
    private Node<T> next;

    public void setValue(T value) {
        element = value;
    }

    @Override
    public T value() {
        return element;
    }

    @Override
    public T get(int index, int myindex) {
        if (index == myindex) {
            return element;
        } else {
            return next.get(index, myindex + 1);
        }
    }

    @Override
    public Node<T> next() {
        return next;
    }

    public NotEmpty(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public int size() {
        return 1 + next.size();
    }

    @Override
    public Node<T> addToEnd(T element) {
        next = next.addToEnd(element);
        return this;
    }

    @Override
    public Node<T> add(int index, int myindex, T element) {
        if ((index - 1) == myindex) {
            Node<T> hold_next = next;
            next = new NotEmpty<>(element, hold_next);
        } else {
            next = next.add(index, myindex + 1, element);
        }
        return this;
    }

    @Override
    public Node<T> remove(int index, int myindex) {
        if ((index - 1) == myindex) {
            next = next.next();
        } else {
            next = next.remove(index, myindex + 1);
        }
        return this;
    }

    @Override
    public int indexOf(T element, int myindex) {
        if (element == this.element) {
            return myindex;
        } else {
            return next.indexOf(element, myindex + 1);
        }
    }

    @Override
    public <R> SimpleRecursiveList<R> map(Function<T, R> function) {
        SimpleRecursiveList<R> mapped = next.map(function);
        mapped.add(0, function.apply(this.element));
        return mapped;
    }
}
