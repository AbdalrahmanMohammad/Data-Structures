import java.util.Iterator;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
          MyLinkedList<Integer> list = new MyLinkedList<>();

        // Add elements to the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original list:");
        list.print();

        // Test 1: Swap nodes in the middle (indexes 1 and 3)
        list.swap(1, 3);
        System.out.println("After swapping indexes 1 and 3 (2 <-> 4):");
        list.print();

        // Test 2: Swap head and tail (indexes 0 and 4)
        list.swap(0, 4);
        System.out.println("After swapping head and tail (1 <-> 5):");
        list.print();

        // Test 3: Swap adjacent nodes (indexes 2 and 3)
        list.swap(2, 3);
        System.out.println("After swapping adjacent nodes (3 <-> 1):");
        list.print();

        // Test 4: Swap with itself (indexes 2 and 2)
        list.swap(2, 2);
        System.out.println("After swapping index 2 with itself:");
        list.print();

        // Test 5: Invalid indices (out of bounds)
        list.swap(-1, 10);  // Should print "falsy inputs"
        System.out.println("After attempting to swap with invalid indices (-1, 10):");
        list.print();

        // Test 6: Swap with the first node (index 0) and a middle node (index 2)
        list.swap(0, 2);
        System.out.println("After swapping head with a middle node (5 <-> 3):");
        list.print();
    }
}