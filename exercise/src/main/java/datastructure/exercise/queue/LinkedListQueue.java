package datastructure.exercise.queue;

import datastructure.exercise.list.LinkedNode;

public class LinkedListQueue<E> implements Queue<E> {
    private LinkedNode head, tail;
    private int size = 0;

    public LinkedListQueue() {
        this.head = new LinkedNode();
        this.tail = this.head;
    }

    @Override
    public void enqueue(E data) {
        tail.next = new LinkedNode(data);
        tail = tail.next;
        if (head.next == null) {
            head.next = tail;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (head == tail) {
            return null;
        }
        LinkedNode delNode = head.next;
        head = delNode.next;
        if (tail == delNode) {
            tail = head;
        }
        size--;
        return (E) delNode.data;
    }

    @Override
    public boolean empty() {
        return head == tail;
    }

    @Override
    public E peek() {
        if (empty()) {
            return null;
        }
        return (E) head.next.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        LinkedNode<E> p = head.next;
        StringBuilder buffer = new StringBuilder("queue from head to tail:");
        while (p != tail.next) {
            buffer.append(p.data).append(",");
            p = p.next;
        }
        buffer.append("size is:").append(size());
        System.out.println(buffer.toString());
    }
}
