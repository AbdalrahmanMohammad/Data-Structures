import java.util.Iterator;

public class MyCircularLinkedList<T> {
    int size;
    Node<T> head;
    Node<T> tail;

    MyCircularLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    MyCircularLinkedList(T val) {
        head = new Node<T>(val);
        head.setNext(head);
        tail = head;
        size++;
    }

    public void add(T val) {
        if (head == null) {
            head = new Node<T>(val);
            head.setNext(head);
            tail = head;
        } else {
            tail.setNext(new Node<T>(val));
            tail = tail.getNext();
            tail.setNext(head);
        }
        size++;
    }

    public void addFirst(T val) {
        Node<T> temp = new Node<>(val);
        if (head == null) {
            head = temp;
            head.setNext(head);
            tail = temp;
        } else {
            temp.setNext(head);
            head = temp;
            tail.setNext(head);
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
            size++;
        }
    }

    public void print() {
        StringBuilder ans = new StringBuilder("{ ");
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("{}");
            return;
        }

        do {
            ans.append(temp.getValue()).append(" | ");
            temp = temp.getNext();
        } while (temp != head);

        if (ans.length() > 2) {
            ans.setLength(ans.length() - 3); // Remove the last " | "
        }
        ans.append(" } ");
        ans.append(size);
        System.out.println(ans.toString());
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
        if (k >= size || k < 0) {
            System.out.println("that is out of range");
            return null;
        } else {
            Node<T> temp = head;
            for (int i = 0; i < k; i++) {
                temp = temp.getNext();
            }
            return temp.getValue();
        }
    }

    public boolean contains(T val) {
        Node<T> temp = head;
        if (head == null)
            return false;
        do {
            if (temp.getValue().equals(val))
                return true;
            temp = temp.getNext();
        } while (temp != head);

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    public void removeFirst() {
        if (size <= 1) {
            clear();
            return;
        }
        head = head.getNext();
        tail.setNext(head);
        size--;
    }

    public void removeLast() {
        if (size <= 1) {
            clear();
            return;
        }
        Node<T> temp = head;
        while (temp.getNext() != tail) {
            temp = temp.getNext();
        }
        temp.setNext(head);
        tail = temp;
        size--;
    }

    public void removeAtIndex(int k) {
        if (k < 0 || k >= size) {
            System.out.println("out of bound");
        } else if (k == 0) {
            removeFirst();
        } else if (k == size - 1) {
            removeLast();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < k - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            size--;
        }
    }

    // @Override
    // public Iterator<T> iterator() {
    // return new myIterator();
    // }

    // private class myIterator implements Iterator<T> {
    // Node<T> temp = head;

    // @Override
    // public boolean hasNext() {
    // return temp != null;
    // }

    // @Override
    // public T next() {
    // T x = temp.getValue();
    // temp = temp.getNext();
    // return x;
    // }

    // }

    // public void reverse() {
    // Node<T> temp = head, headd = head, taill = tail;
    // while (temp != null) {
    // Node<T> aa = temp.getNext();
    // temp.setNext(temp.getPrevious());
    // temp.setPrevious(aa);
    // temp = temp.getPrevious();
    // }
    // temp = headd;
    // head = taill;
    // tail = temp;
    // }

    // public void reverse2() {
    // Node<T> headd = head, taill = tail;

    // Node<T> temp, prev = null;

    // while (head != null) {
    // temp = head.getNext();
    // head.setNext(prev);
    // head.setPrevious(temp);
    // prev = head;
    // head = temp;
    // }

    // temp = headd;
    // head = taill;
    // tail = temp;
    // }

    // public void reverse3() {
    // Node<T> temp = head, headd = head, taill = tail;
    // reverseHelper(temp);
    // temp = headd;
    // head = taill;
    // tail = temp;
    // tail.setNext(null);
    // head.setPrevious(null);
    // }

    // public Node<T> reverseHelper(Node<T> head) {
    // if (head == null || head.getNext() == null) {
    // return head;
    // }

    // Node<T> next=head.getNext();
    // Node<T> rest = reverseHelper(head.getNext());
    // next.setNext(head);
    // head.setPrevious(next);
    // return rest;

    // }

}
