import java.util.LinkedList;

public class MyQueue<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T t) {
        if (head == null && tail == null) {
            head = new Node(t);
            tail = head;
        } else {
            tail.setNext(new Node(t));
            tail = tail.getNext();
        }
        size++;
    }

    public T dequeue() {
        if (!isempty()) {
            T t = head.getValue();
            if (head == tail) {
                tail = head = null;
            } else
                head = head.getNext();
            size--;
            return t;
        }
        return null;
    }

    public T peek() {
        if (!isempty()) {
            return head.getValue();
        }
        return null;
    }

    public boolean isempty() {
        return head == null;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (head == null)
            System.out.println("empty");
        else {
            Node<T> temp = head;
            System.out.print("{");
            while (temp != null) {
                System.out.print(temp.getValue() + " ");
                temp = temp.getNext();
            }
            System.out.println("}");
        }
    }

}
