import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
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

    public boolean contains(T val) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getValue().equals(val))
                return true;
            temp = temp.getNext();
        }
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
        size--;
        if (head == null)
            tail = null;
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
        temp.setNext(null);
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

    @Override
    public Iterator<T> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<T>{
        Node<T> temp=head;

        @Override
        public boolean hasNext() {
            return temp!=null;
        }

        @Override
        public T next() {
            T x= temp.getValue();
            temp=temp.getNext();
            return x;
        }

    }


}
