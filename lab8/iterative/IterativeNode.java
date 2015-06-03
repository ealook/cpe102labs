/**
 * Created by ethan on 5/20/15.
 */
public class IterativeNode<T> {

    private T value;
    private IterativeNode<T> next;

    public IterativeNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public IterativeNode<T> getNext() {
        return next;
    }

    public void setNext(IterativeNode<T> next) {
        this.next = next;
    }
}
