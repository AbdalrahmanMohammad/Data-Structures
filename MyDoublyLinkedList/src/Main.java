public class Main {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();

        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Print the list
        System.out.println("Initial list:");
        list.print(); // Should print { 10 | 20 | 30 | 40 | 50 } size: 5

        // Test removeFirst
        list.removeFirst();
        System.out.println("After removeFirst:");
        list.print(); // Should print { 20 | 30 | 40 | 50 } size: 4
        for(int a:list)
        {
            System.out.println(a+1);
        }

        // Test removeLast
        list.removeLast();
        System.out.println("After removeLast:");
        list.print(); // Should print { 20 | 30 | 40 } size: 3

        // Test removeAtIndex
        list.removeAtIndex(1);
        System.out.println("After removeAtIndex(1):");
        list.print(); // Should print { 20 | 40 } size: 2

        // Edge case: Remove the first element again
        list.removeAtIndex(0);
        System.out.println("After removeAtIndex(0):");
        list.print(); // Should print { 40 } size: 1

        // Edge case: Remove the last element (only element left)
        list.removeAtIndex(0);
        System.out.println("After removeAtIndex(0) again:");
        list.print(); // Should print { } size: 0

        // Edge case: Try to remove from an empty list
        list.removeFirst(); // Should not alter the list
        list.removeLast(); // Should not alter the list
        list.removeAtIndex(0); // Should print "out of bound"

        // Final state of the list
        System.out.println("Final list:");
        list.print(); // Should print { } size: 0
    }
}
