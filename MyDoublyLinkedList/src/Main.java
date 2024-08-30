public class Main {
    public static void main(String[] args) {
        MyCircularLinkedList<Integer> list = new MyCircularLinkedList<>();

        // Test isEmpty() on a new list
        System.out.println("List is empty: " + list.isEmpty()); // Expected: true

        // Test add(T val) and print()
        // list.add(10);
        // list.add(20);
        // list.add(30);
        System.out.print("List after adding elements (10, 20, 30): ");
        list.print(); // Expected: { 10 | 20 | 30 } 3

        // Test addFirst(T val)
        list.addFirst(5);
        System.out.print("List after addFirst(5): ");
        list.print(); // Expected: { 5 | 10 | 20 | 30 } 4

        System.out.println("****************");
        for (int i : list)
            System.out.println(i);
        System.out.println("****************");

        for (int i : list)
            System.out.println(i);
    }
}
