import java.util.function.Function;

/**
 * Created by ethan on 5/22/15.
 */
public class RecursiveList<T> implements SimpleRecursiveList<T> {

    private Node<T> head;

    public RecursiveList() {
        head = new Empty<>();
    }

    @Override
    public void addToEnd(T element) {
        head = head.addToEnd(element);
    }

    @Override
    public void add(int index, T element) {
        if (index == 0) {
            Node<T> holder = head;
            head = new NotEmpty<T>(element, holder);
        } else {
            head = head.add(index, 0, element);
        }
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            head = head.next();
        } else {
            head = head.remove(index, 0);
        }
    }

    @Override
    public T get(int index) {
        return head.get(index, 0);
    }

    @Override
    public int indexOf(T element) {
        return head.indexOf(element, 0);
    }

    @Override
    public int size() {
        return head.size();
    }

    @Override
    public <R> SimpleRecursiveList<R> map(Function<T, R> function) {
        return head.map(function);
    }
}
