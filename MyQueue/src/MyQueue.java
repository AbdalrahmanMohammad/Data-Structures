public class MyQueue<T> {
    T[] arr;
    int front;
    int rear;
    int size;

    @SuppressWarnings("unchecked")
    MyQueue(int a) {
        arr = (T[]) new Object[a];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T t) {
        if (isfull()) {
            System.out.println("queue is full");
        } else {
            arr[++rear] = t;
            size++;
        }
    }

    public T dequeue() {
        if (!isempty()) {
            size--;
            T val = arr[front++];
            if (isempty())
                clear();
            return val;
        }
        return null;
    }

    public T peek() {
        if (!isempty()) {
            return arr[front];
        }
        return null;
    }

    public boolean isfull() {
        return rear == arr.length - 1;
    }

    public boolean isempty() {
        return rear < front;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isempty())
            System.out.println("empty");
        else {
            System.out.print("{");
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("}");
        }
    }

}
