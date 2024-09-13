public class Node<T> {
    private T value;
    private Node<T> next;

    Node(T val) {
        value = val;
        next = null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

}