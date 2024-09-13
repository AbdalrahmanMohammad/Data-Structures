public class App {
    public static void main(String[] args) throws Exception {
        MyQueue<Integer> queue = new MyQueue<>();

        // Test enqueue
        System.out.println("Enqueue 1, 2, 3:");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display(); // Expected output: { 1 2 3 }

        // Test peek
        System.out.println("Peek: " + queue.peek()); // Expected output: 1

        // Test dequeue
        System.out.println("Dequeue: " + queue.dequeue()); // Expected output: 1
        queue.display(); // Expected output: { 2 3 }

        // Test dequeue on non-empty queue
        System.out.println("Dequeue: " + queue.dequeue()); // Expected output: 2
        queue.display(); // Expected output: { 3 }

        // Test clear
        queue.clear();
        System.out.println("Queue cleared");
        queue.display(); // Expected output: empty

        // Test dequeue on empty queue
        System.out.println("Dequeue: " + queue.dequeue()); // Expected output: null
    }
}
