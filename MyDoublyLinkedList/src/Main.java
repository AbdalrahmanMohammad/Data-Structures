public class Main {
    public static void main(String[] args) {
        MyCircularLinkedList<Integer> list = new MyCircularLinkedList<>();


        // Test isEmpty() on a new list
        System.out.println("List is empty: " + list.isEmpty()); // Expected: true

        // Test add(T val) and print()
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.print("List after adding elements (10, 20, 30): ");
        list.print(); // Expected: { 10 | 20 | 30 } 3

        // Test addFirst(T val)
        list.addFirst(5);
        System.out.print("List after addFirst(5): ");
        list.print(); // Expected: { 5 | 10 | 20 | 30 } 4

        // Test addAtIndex(int k, T val)
        list.addAtIndex(2, 15);
        System.out.print("List after addAtIndex(2, 15): ");
        list.print(); // Expected: { 5 | 10 | 15 | 20 | 30 } 5

        // Test getFirst()
        System.out.println("First element: " + list.getFirst()); // Expected: 5

        // Test getLast()
        System.out.println("Last element: " + list.getLast()); // Expected: 30

        // Test getAtIndex(int k)
        System.out.println("Element at index 2: " + list.getAtIndex(2)); // Expected: 15
        System.out.println("Element at index 0: " + list.getAtIndex(0)); // Expected: 5
        System.out.println("Element at index 4: " + list.getAtIndex(4)); // Expected: 30

        // Test contains(T val)
        System.out.println("List contains 15: " + list.contains(15)); // Expected: true
        System.out.println("List contains 100: " + list.contains(100)); // Expected: false

        // Test removeFirst()
        list.removeFirst();
        System.out.print("List after removeFirst(): ");
        list.print(); // Expected: { 10 | 15 | 20 | 30 } 4

        // Test removeLast()
        list.removeLast();
        System.out.print("List after removeLast(): ");
        list.print(); // Expected: { 10 | 15 | 20 } 3

        // Test removeAtIndex(int k)
        list.removeAtIndex(1);
        System.out.print("List after removeAtIndex(1): ");
        list.print(); // Expected: { 10 | 20 } 2

        // Test clear()
        list.clear();
        System.out.print("List after clear(): ");
        list.print(); // Expected: {} 0

        // Ensure the list is empty after clear
        System.out.println("List is empty after clear: " + list.isEmpty()); // Expected: true

        // Test boundary cases for removeAtIndex()
        list.add(100);
        list.add(200);
        list.removeAtIndex(0); // Removing the first element when there's only one element
        System.out.print("List after removeAtIndex(0) on a single-element list: ");
        list.print(); // Expected: { 200 } 1
    }
}
