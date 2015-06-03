import java.util.function.Function;

/**
 * Created by ethan on 5/22/15.
 */
public interface Node<T> {

    T value();
    Node<T> next();
    int size();
    T get(int index, int myindex);
    Node<T> addToEnd(T element);

    Node<T> add(int index, int i, T element);

    Node<T> remove(int index, int i);

    int indexOf(T element, int myindex);

    <R> SimpleRecursiveList<R> map(Function<T, R> function);
}
