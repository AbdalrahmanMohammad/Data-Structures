import java.util.Iterator;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
          MyLinkedList<Integer> list = new MyLinkedList<>();

        // Add elements to the list
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(3);
        list.print();
        list.sort();
        list.print();

    }
}