
public class MyLinkedList<T> {
    int size;
    Node<T> head;
    Node<T> tail;

    MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    MyLinkedList(T val) {
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
            tail = tail.getNext();
        }
        size++;
    }

    public void addFirst(T val) {
        Node<T> temp = new Node<>(val);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head);
            head = temp;
        }
        size++;
    }

    public void addAtIndex(int k, T val) {
        if (k > size) {
            System.out.println("that is out of range");
        } else if (k == size) {
            add(val);
        } else if (k == 0) {
            addFirst(val);
        } else {
            Node<T> temp = head, newNode = new Node<>(val);
            for (int i = 0; i < k - 1; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            size++;
        }

    }

    public int getSize() {
        return size;
    }

    public T getFirst() {
        return head.getValue();
    }

    public T getLast() {
        return tail.getValue();
    }

    public T getAtIndex(int k) {
        if (k >= size) {
            System.out.println("that is out of range");
            return null;
        } else if (k == 0) {
            return getFirst();
        } else if (k == size - 1) {
            return getLast();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < k; i++) {
                temp = temp.getNext();
            }
            return temp.getValue();
        }
    }

    public boolean contains(T val)
    {
        Node<T> temp = head;
        while (temp!=null) {
            if(temp.getValue().equals(val))
            return true;
            temp = temp.getNext();
        }
        return false;
    }

    public void print() {
        StringBuilder ans = new StringBuilder("{ ");
        Node<T> temp = head;
        while (temp != null) {
            ans.append(temp.getValue()).append(" | ");
            temp = temp.getNext();
        }
        if (ans.length() > 2) {
            ans.setLength(ans.length() - 2); // Remove the last " | "
        }
        ans.append(" }");
        System.out.println(ans.toString());
    }

}
