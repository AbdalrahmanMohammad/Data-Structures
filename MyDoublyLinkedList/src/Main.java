public class Main {
    public static void main(String[] args) {
        MyCircularLinkedList<Integer> list = new MyCircularLinkedList<>();

        // Test: Adding elements to the list
        System.out.println("Adding elements:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.print(); // Expected output: { 10 | 20 | 30 } 3

        // Test: Adding an element at the beginning
        System.out.println("\nAdding element at the beginning:");
        list.addFirst(5);
        list.print(); // Expected output: { 5 | 10 | 20 | 30 } 4

        // Test: Adding an element at a specific index
        System.out.println("\nAdding element at index 2:");
        list.addAtIndex(2, 15);
        list.print(); // Expected output: { 5 | 10 | 15 | 20 | 30 } 5

        // Test: Adding an element at the end (same as adding normally)
        System.out.println("\nAdding element at the end:");
        list.addAtIndex(list.size, 35);
        list.print(); // Expected output: { 5 | 10 | 15 | 20 | 30 | 35 } 6

        // Test: Attempting to add at an invalid index
        System.out.println("\nAdding element at invalid index:");
        list.addAtIndex(10, 50); // Expected output: that is out of range
        list.print(); // Expected output: { 5 | 10 | 15 | 20 | 30 | 35 } 6

        // Test: Creating a list with a single initial value
        System.out.println("\nCreating a new list with an initial value:");
        MyCircularLinkedList<String> stringList = new MyCircularLinkedList<>("Hello");
        stringList.print(); // Expected output: { Hello } 1

        // Test: Adding more elements to the new list
        stringList.add("World");
        stringList.print(); // Expected output: { Hello } 1

        stringList.add("!");
        stringList.print(); // Expected output: { Hello | World | ! } 3
        
    }
}
