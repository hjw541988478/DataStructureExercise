package ds.exercise.stack;

public class ArrayStack<E> implements Stack<E> {
    private int top = -1;
    private static final int MAX_STACK_SIZE = 100;
    private Object[] objects;

    public ArrayStack() {
        objects = new Object[MAX_STACK_SIZE];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E pop() {
        if (top == -1) {
            return null;
        }
        return (E) objects[top--];
    }

    @Override
    public void push(E data) {
        if (top == MAX_STACK_SIZE - 1) {
            throw new IllegalArgumentException("already reach max size");
        }
        objects[++top] = data;
    }

    @Override
    public E peek() {
        if (top == -1) {
            return null;
        }
        return (E) objects[top];
    }

    @Override
    public void clear() {
        while (top != -1) {
            pop();
        }
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("current stack top to bottom:");
        int index = top;
        while (index != -1) {
            sb.append(objects[index--] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" size :" + size());
        System.out.println(sb.toString());
    }
}
