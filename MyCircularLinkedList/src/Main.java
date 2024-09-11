public class Main {
    public static void main(String[] args) {
        MyCircularLinkedList<Integer> list = new MyCircularLinkedList<>();

        // Test isEmpty() on a new list
        System.out.println("List is empty: " + list.isEmpty()); // Expected: true

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.print("List after adding elements (10, 20, 30): ");
        list.print(); // Expected: { 10 | 20 | 30 } 3

        list.rotate(6);
        list.print();

    }
}
