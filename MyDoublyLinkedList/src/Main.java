public class Main {
public static void main(String[] args) {
    MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();

    // Test add(T val)
    list.add(10);
    list.add(20);
    list.add(30);
    list.print(); // Expected output: { 10 | 20 | 30 } 3

    // Test addFirst(T val)
    list.addFirst(5);
    list.print(); // Expected output: { 5 | 10 | 20 | 30 } 4

    // Test addAtIndex(int k, T val)
    list.addAtIndex(2, 15);
    list.print(); // Expected output: { 5 | 10 | 15 | 20 | 30 } 5

    // Test adding at the end using addAtIndex
    list.addAtIndex(5, 35);
    list.print(); // Expected output: { 5 | 10 | 15 | 20 | 30 | 35 } 6
    list.printReversed();


    // Test adding at index 0 using addAtIndex
    list.addAtIndex(0, 0);
    list.print(); // Expected output: { 0 | 5 | 10 | 15 | 20 | 30 | 35 } 7

    // Test out of range index for addAtIndex
    list.addAtIndex(10, 50); // Expected output: "that is out of range"
    list.print(); // Should remain unchanged: { 0 | 5 | 10 | 15 | 20 | 30 | 35 } 7
    list.printReversed();
}
}
