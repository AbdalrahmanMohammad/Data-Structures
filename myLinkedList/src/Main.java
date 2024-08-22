
class Main {
    public static void main(String[] args) {
        // Create a new linked list
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Test addLast method
        list.add(10); // Adding 10 to the end
        list.add(20); // Adding 20 to the end
        list.add(30); // Adding 30 to the end
        System.out.println("List after adding elements: ");
        list.print(); // Expected output: 10 -> 20 -> 30

        // Test addFirst method
        list.addFirst(5); // Adding 5 to the beginning
        System.out.println("List after adding 5 at the beginning: ");
        list.print(); // Expected output: 5 -> 10 -> 20 -> 30

        // Test addAtIndex method
        list.addAtIndex(2, 15); // Adding 15 at index 2
        System.out.println("List after adding 15 at index 2: ");
        list.print(); // Expected output: 5 -> 10 -> 15 -> 20 -> 30

        list.addAtIndex(0, 2); // Adding 2 at index 0
        System.out.println("List after adding 2 at index 0: ");
        list.print(); // Expected output: 2 -> 5 -> 10 -> 15 -> 20 -> 30

        list.addAtIndex(6, 35); // Adding 35 at the end
        System.out.println("List after adding 35 at the end: ");
        list.print(); // Expected output: 2 -> 5 -> 10 -> 15 -> 20 -> 30 -> 35
        System.out.println(list.contains(8));
        System.out.println(list.contains(2));
        System.out.println(list.contains(35));
        System.out.println(list.contains(25));
        System.out.println(list.contains(20));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getAtIndex(0));
        System.out.println(list.getAtIndex(10));
        System.out.println(list.getAtIndex(5));


    }
}