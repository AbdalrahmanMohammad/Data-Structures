public class App {
    public static void main(String[] args) throws Exception {
        // Test Case 1: Enqueue and Dequeue Operations
        System.out.println("Test Case 1: Enqueue and Dequeue Operations");
        MyQueue<Integer> queue1 = new MyQueue<>(5);
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.display(); // Expected: {1 2 3}
        System.out.println("\nDequeued element: " + queue1.dequeue()); // Expected: 1
        queue1.display(); // Expected: {2 3}
        System.out.println();

        // Test Case 2: Peek Operation
        System.out.println("Test Case 2: Peek Operation");
        System.out.println("Peek element: " + queue1.peek()); // Expected: 2
        System.out.println();

        // Test Case 3: Check Empty Queue
        System.out.println("Test Case 3: Check Empty Queue");
        MyQueue<Integer> queue2 = new MyQueue<>(3);
        System.out.println("Is queue empty? " + queue2.isempty()); // Expected: true
        queue2.enqueue(5);
        System.out.println("Is queue empty? " + queue2.isempty()); // Expected: false
        System.out.println("Dequeued element: " + queue2.dequeue()); // Expected: 5
        System.out.println("Is queue empty? " + queue2.isempty()); // Expected: true
        System.out.println();

        // Test Case 4: Check Full Queue
        System.out.println("Test Case 4: Check Full Queue");
        MyQueue<Integer> queue3 = new MyQueue<>(2);
        queue3.enqueue(10);
        queue3.enqueue(20);
        queue3.enqueue(30); // Expected: queue is full
        queue3.display(); // Expected: {10 20}
        System.out.println();

        // Test Case 5: Queue Size and Clear Operations
        System.out.println("Test Case 5: Queue Size and Clear Operations");
        MyQueue<String> queue4 = new MyQueue<>(4);
        queue4.enqueue("a");
        queue4.enqueue("b");
        queue4.enqueue("c");
        System.out.println("Queue size: " + queue4.size()); // Expected: 3
        queue4.clear();
        queue4.display(); // Expected: empty
        System.out.println("Queue size after clear: " + queue4.size()); // Expected: 0
        System.out.println();

        // Test Case 6: Dequeue on Empty Queue
        System.out.println("Test Case 6: Dequeue on Empty Queue");
        MyQueue<Integer> queue5 = new MyQueue<>(2);
        System.out.println("Dequeued element from empty queue: " + queue5.dequeue()); // Expected: null

    }
}
