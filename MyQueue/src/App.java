public class App {
    public static void main(String[] args) {
        MyDequeue<Integer> dequeue = new MyDequeue<>(5); // Create a deque with size 5

        System.out.println("Initial Deque:");
        dequeue.display(); // Should print "empty"

        // Test addLast (enqueue equivalent)
        System.out.println("\nAdding elements to the back (addLast):");
        dequeue.addLast(1);
        dequeue.addLast(2);
        dequeue.addLast(3);
        dequeue.display(); // Expected output: {1 2 3}

        // Test addFirst (push equivalent)
        System.out.println("\nAdding elements to the front (addFirst):");
        dequeue.addFirst(0);
        dequeue.addFirst(-1);
        dequeue.display(); // Expected output: {-1 0 1 2 3}

        // Test addLast when full
        System.out.println("\nTrying to add to a full deque (addLast):");
        dequeue.addLast(4); // Expected output: "queue is full"
        dequeue.display(); // Expected output: {-1 0 1 2 3}

        // Test removeFirst (dequeue equivalent)
        System.out.println("\nRemoving elements from the front (removeFirst):");
        System.out.println("Removed: " + dequeue.removeFirst()); // Should remove -1
        dequeue.display(); // Expected output: {0 1 2 3}

        // Test removeLast (pop equivalent from the back)
        System.out.println("\nRemoving elements from the back (removeLast):");
        System.out.println("Removed: " + dequeue.removeLast()); // Should remove 3
        dequeue.display(); // Expected output: {0 1 2}

        // Test peek
        System.out.println("\nPeeking at the front element (peek):");
        System.out.println("Peeked: " + dequeue.peek()); // Expected output: 0

        // Test size
        System.out.println("\nChecking size:");
        System.out.println("Size: " + dequeue.size()); // Expected output: 3

        // Emptying the deque
        System.out.println("\nRemoving all elements:");
        System.out.println(dequeue.removeFirst()); // Remove 0
        System.out.println(dequeue.removeFirst()); // Remove 1
        System.out.println(dequeue.removeFirst()); // Remove 2
        dequeue.display(); // Expected output: "empty"

        // Test removing from an empty deque
        System.out.println("\nTrying to remove from empty deque:");
        System.out.println("Removed: " + dequeue.removeFirst()); // Expected output: null
        dequeue.display(); // Expected output: "empty"

        // Test addFirst on an empty deque
        System.out.println("\nAdding to the front of an empty deque (addFirst):");
        dequeue.addFirst(5);

        dequeue.addFirst(4);
        dequeue.addLast(1);
        dequeue.display(); // Expected output: {5}

        // Test clear function
        System.out.println("\nClearing the deque:");
        dequeue.clear();
        dequeue.display(); // Expected output: "empty"
    }
}
