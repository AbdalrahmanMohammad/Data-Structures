public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;

    Node(T val) {
        value = val;
        next = null;
        previous = null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public T getValue() {
        return value;
    }

}
