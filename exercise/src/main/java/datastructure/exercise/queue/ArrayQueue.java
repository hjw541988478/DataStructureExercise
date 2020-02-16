package datastructure.exercise.queue;

public class ArrayQueue<E> implements Queue<E> {
    private int head = 0, tail = 0;
    private static int MAX_QUEUE_SIZE = 100;
    private Object[] queue;

    public ArrayQueue() {
        queue = new Object[MAX_QUEUE_SIZE];
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(E data) {
        if (tail >= MAX_QUEUE_SIZE) {
            throw new IllegalArgumentException("already reach max size");
        }
        queue[tail++] = data;
    }

    @Override
    public E dequeue() {
        if (empty()) {
            return null;
        }
        E data = (E) queue[head];
        // move data to fill empty position
        int i = head;
        while (i < tail - 1) {
            queue[i] = queue[i + 1];
            i++;
        }
        tail--;
        return data;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public E peek() {
        if (empty()) {
            return null;
        }
        return (E) queue[head];
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public void print() {
        StringBuilder buffer = new StringBuilder("queue from head to tail:");
        int i = head;
        while (i < tail) {
            buffer.append(queue[i++]).append(",");
        }
        buffer.append(" size is:" + size());
        System.out.println(buffer.toString());
    }
}
