public class App {
    public static void main(String[] args) {
        // Create a circular queue with a capacity of 5
        MyCircularQueue<Integer> queue = new MyCircularQueue<>(5);

        // Test isEmpty on an empty queue
        System.out.println("Is the queue empty? " + queue.isempty()); // true

        // Test enqueue operation
        System.out.println("\nEnqueueing elements...");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        // The queue should be full now
        System.out.println("Is the queue full? " + queue.isfull()); // true
        queue.enqueue(60); // This should print "queue is full"

        // Display the queue contents
        System.out.print("Queue after enqueues: ");
        queue.display(); // Output should be {10 20 30 40 50}

        // Test peek
        System.out.println("\nPeek: " + queue.peek()); // Should return 10 (front element)

        // Test dequeue operation
        System.out.println("\nDequeueing elements...");
        System.out.println("Dequeued: " + queue.dequeue()); // Should return 10
        System.out.println("Dequeued: " + queue.dequeue()); // Should return 20
        
        // Display the queue after dequeues
        System.out.print("Queue after dequeues: ");
        queue.display(); // Output should be {30 40 50}

        // Test size
        System.out.println("\nCurrent size: " + queue.size()); // Should return 3

        // Enqueue more elements
        queue.enqueue(60);
        queue.enqueue(70);

        // Display the queue after more enqueues
        System.out.print("Queue after more enqueues: ");
        queue.display(); // Output should be {30 40 50 60 70}

        // Test dequeue until the queue is empty
        System.out.println("\nDequeueing all elements...");
        while (!queue.isempty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // The queue should be empty now
        System.out.println("Is the queue empty? " + queue.isempty()); // true
        System.out.println("********************************************************8");
                // Test isEmpty on an empty queue
                System.out.println("Is the queue empty? " + queue.isempty()); // true

                // Test enqueue operation
                System.out.println("\nEnqueueing elements...");
                queue.enqueue(10);
                queue.enqueue(20);
                queue.enqueue(30);
                queue.enqueue(40);
                queue.enqueue(50);
                
                // The queue should be full now
                System.out.println("Is the queue full? " + queue.isfull()); // true
                queue.enqueue(60); // This should print "queue is full"
        
                // Display the queue contents
                System.out.print("Queue after enqueues: ");
                queue.display(); // Output should be {10 20 30 40 50}
        
                // Test peek
                System.out.println("\nPeek: " + queue.peek()); // Should return 10 (front element)
        
                // Test dequeue operation
                System.out.println("\nDequeueing elements...");
                System.out.println("Dequeued: " + queue.dequeue()); // Should return 10
                System.out.println("Dequeued: " + queue.dequeue()); // Should return 20
                
                // Display the queue after dequeues
                System.out.print("Queue after dequeues: ");
                queue.display(); // Output should be {30 40 50}
        
                // Test size
                System.out.println("\nCurrent size: " + queue.size()); // Should return 3
        
                // Enqueue more elements
                queue.enqueue(60);
                queue.enqueue(70);
        
                // Display the queue after more enqueues
                System.out.print("Queue after more enqueues: ");
                queue.display(); // Output should be {30 40 50 60 70}
        
                // Test dequeue until the queue is empty
                System.out.println("\nDequeueing all elements...");
                while (!queue.isempty()) {
                    System.out.println("Dequeued: " + queue.dequeue());
                }
        
                // The queue should be empty now
                System.out.println("Is the queue empty? " + queue.isempty()); // true
    }
}
