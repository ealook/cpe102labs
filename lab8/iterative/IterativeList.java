import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * Created by ethan on 5/20/15.
 */
public class IterativeList<T> implements SimpleList<T> {

    private IterativeNode<T> head;

    public IterativeList() {
        this.head = null;
    }

    @Override
    public void addToEnd(T element) {
        IterativeNode<T> cur = head;

        if (cur == null) {
            head = new IterativeNode<>(element);
        } else {
            while (cur != null) {
                if (cur.getNext() == null) {
                    cur.setNext(new IterativeNode<>(element));
                    return;
                }
                cur = cur.getNext();
            }
        }
    }

    @Override
    public void add(int index, T element) {
        if (index == 0) {
            IterativeNode<T> new_node = new IterativeNode<>(element);
            new_node.setNext(head);
            this.head = new_node;
        } else {
            int i = 0;
            IterativeNode<T> cur = head;

            while (cur != null) {
                if (i == index - 1) {
                    IterativeNode<T> new_node = new IterativeNode<>(element);
                    new_node.setNext(cur.getNext());
                    cur.setNext(new_node);
                    return;
                }
                i++;
                cur = cur.getNext();
            }
            throw new IndexOutOfBoundsException(index + " is out of bounds!");
        }
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
        } else {
            int i = 0;
            IterativeNode<T> cur = head;
            boolean found = false;

            while (cur != null) {
                if (i == index - 1) {
                    cur.setNext(cur.getNext().getNext());
                    return;
                }
                i++;
                cur = cur.getNext();
            }
            throw new IndexOutOfBoundsException(index + " is out of bounds!");
        }
    }

    @Override
    public T get(int index) {
        int i = 0;
        IterativeNode<T> cur = head;

        while (cur != null) {
            if (i == index) {
                return cur.getValue();
            }
            i++;
            cur = cur.getNext();
        }
        throw new IndexOutOfBoundsException(index + " is out of bounds!");
    }

    @Override
    public int indexOf(T element) {
        int i = 0;
        IterativeNode<T> cur = head;

        while (cur != null) {
            if (element == cur.getValue()) {
                return i;
            }
            i++;
            cur = cur.getNext();
        }
        throw new NoSuchElementException("Element was not found!");
    }

    @Override
    public int size() {
        int i = 0;
        IterativeNode<T> cur = head;

        while (cur != null) {
            i++;
            cur = cur.getNext();
        }

        return i;
    }

    @Override
    public <R> SimpleList<R> map(Function<T, R> function) {
        IterativeNode<T> cur = head;
        SimpleList<R> ret_list = new IterativeList<>();

        while (cur != null) {
            ret_list.addToEnd(function.apply(cur.getValue()));
            cur = cur.getNext();
        }

        return ret_list;
    }
}
