public class MyDoublyLinkedList<T> {
    int size;
    Node<T> head;
    Node<T> tail;

    MyDoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    MyDoublyLinkedList(T val) {
        head = new Node<T>(val);
        tail = head;
        size++;
    }

    public void add(T val) {
        if (head == null) {
            head = new Node<T>(val);
            tail = head;
        } else {
            tail.setNext(new Node<T>(val));
            tail.getNext().setPrevious(tail);;
            tail = tail.getNext();
        }
        size++;
    }

}
