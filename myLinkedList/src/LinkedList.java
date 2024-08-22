
public class LinkedList<T> {
    int size;
    Node<T> head;
    Node<T> tail;

    LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    LinkedList(T val) {
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
            tail=tail.getNext();
        }
        size++;
    }

    public void print() {
        String ans = "{ ";
        Node<T> temp = head;
        while (temp != null) {
            ans += (temp.getValue() + " | ");
            temp = temp.getNext();
        }
        ans = ans.substring(0, ans.length() - 2);
        ans += " }";
        System.out.println(ans);
    }

}
