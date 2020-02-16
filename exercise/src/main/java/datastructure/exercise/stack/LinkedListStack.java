package datastructure.exercise.stack;

import datastructure.exercise.list.LinkedNode;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedNode<E> head;
    private int size;

    public LinkedListStack() {
        this.size = 0;
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E pop() {
        if (head == null) {
            return null;
        }
        LinkedNode topNode = head;
        head = head.next;
        size--;
        return (E) topNode.data;
    }

    @Override
    public void push(E data) {
        if (head == null) {
            head = new LinkedNode<E>(data);
        } else {
            LinkedNode<E> topNode = new LinkedNode<>(data);
            topNode.next = head;
            head = topNode;
        }
        size++;
    }

    @Override
    public E peek() {
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }

    @Override
    public void clear() {
        while (head != null) {
            pop();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        StringBuilder strBuilder = new StringBuilder("current stack order:");
        LinkedNode<E> workNode = head;
        while (workNode != null) {
            strBuilder.append(workNode.data).append(",");
            workNode = workNode.next;
        }
        strBuilder.deleteCharAt(strBuilder.length() - 1);
        strBuilder.append(" size:" + size());
        System.out.println(strBuilder.toString());
    }
}
