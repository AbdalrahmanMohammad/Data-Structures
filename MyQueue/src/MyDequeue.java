import java.util.Iterator;

import org.w3c.dom.Node;

public class MyDequeue<T> implements Iterable<T> {
    T[] arr;
    int front;
    int rear;
    int size;

    @SuppressWarnings("unchecked")
    MyDequeue(int a) {
        arr = (T[]) new Object[a];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void addLast(T t) {// add last
        if (isfull()) {
            System.out.println("queue is full");
        } else {
            rear++;
            rear = rear % arr.length;
            arr[rear] = t;
            size++;
        }
    }

    public void addFirst(T t) {// add first
        if (isfull()) {
            System.out.println("queue is full");
        } else {
            if (isempty()) {
                front = 1;
                rear = 0;
            }
            front--;
            if (front < 0)
                front = arr.length - 1;
            arr[front] = t;
            size++;
        }
    }

    public T removeFirst() {// remove first
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

    public T removeLast() {
        if (!isempty()) {
            size--;
            T val = arr[rear--];
            if (rear < 0)
                rear = arr.length - 1;
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

    @Override
    public Iterator<T> iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator<T> {
        int f = front;
        boolean flag = true;

        @Override
        public boolean hasNext() {
            if (isempty())
                return false;
            if (flag && isfull()) {
                flag = false;
                return true;
            }
            if ((rear + 1) % arr.length == f)
                return false;
            return true;
        }

        @Override
        public T next() {

            T x = arr[f];
            f++;
            f = f % arr.length;

            return x;
        }
    }

}
