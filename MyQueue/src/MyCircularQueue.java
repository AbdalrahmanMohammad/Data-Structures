public class MyCircularQueue<T> {
    T[] arr;
    int front;
    int rear;
    int size;

    @SuppressWarnings("unchecked")
    MyCircularQueue(int a) {
        arr = (T[]) new Object[a];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T t) {
        if (isfull()) {
            System.out.println("queue is full");
        } else {
            rear++;
            rear = rear % arr.length;
            arr[rear] = t;
            size++;
        }
    }

    public T dequeue() {
        if (!isempty()) {
            size--;
            T val = arr[front++];
            if (front >= arr.length)
                front = front % arr.length;
            if ((rear + 1) % arr.length == front) {
                clear();
            }
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
        if (isempty())
            return false;
        return (rear + 1) % arr.length == front;
    }

    public boolean isempty() {
        return rear == -1;
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
            int temp = front;
            while (temp != rear) {
                System.out.print(arr[temp] + " ");
                temp++;
                temp = temp % arr.length;
            }
            System.out.print(arr[temp] + "");
            System.out.print("}");
        }
    }

}
