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
            tail.getNext().setPrevious(tail);
            ;
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
            head.setPrevious(temp);
            head = temp;
        }
        size++;
    }

    public void addAtIndex(int k, T val) {
        if (k > size || k < 0) {
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
            newNode.getNext().setPrevious(newNode);
            newNode.setPrevious(temp);
            size++;
        }
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
        ans.append(" } ");
        ans.append(size);
        System.out.println(ans.toString());
    }

    public void printReversed() {
        StringBuilder ans = new StringBuilder("{ ");
        Node<T> temp = tail;
        while (temp != null) {
            ans.append(temp.getValue()).append(" | ");
            temp = temp.getPrevious();
        }
        if (ans.length() > 2) {
            ans.setLength(ans.length() - 2); // Remove the last " | "
        }
        ans.append(" } ");
        ans.append(size);
        System.out.println(ans.toString());
    }

}
