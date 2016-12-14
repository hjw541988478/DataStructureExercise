package me.huangjiawen.datasturcture.queue.linked;

import me.huangjiawen.datasturcture.list.linked.LinkedNode;
import me.huangjiawen.datasturcture.queue.Queue;

public class LinkedQueue<E> implements Queue<E> {

	LinkedNode<E> front;
	LinkedNode<E> rear;
	int size = 0;

	public LinkedQueue() {
		front = new LinkedNode<>();
		rear = new LinkedNode<>();
		front.next = null;
		rear.next = null;
	}

	@Override
	public void enQueue(E data) {
		LinkedNode<E> newNode = new LinkedNode<E>();
		newNode.data = data;
		newNode.next = null;
		rear.next = newNode;
		rear = newNode;
		if (front.next == null) {
			front.next = newNode;
		}
		size++;
	}

	@Override
	public E deQueue() {
		if (front == rear) {
			return null;
		}
		E deleteData = null;
		LinkedNode<E> toDeleteNode = front.next;
		deleteData = toDeleteNode.data;
		front.next = toDeleteNode.next;
		if (rear == toDeleteNode) {
			rear = front;
		}
		toDeleteNode = null;
		size--;
		return deleteData;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void print() {
		LinkedNode<E> p = front.next;
		StringBuffer buffer = new StringBuffer();
		while (p != rear.next) {
			buffer.append(p.data).append(",");
			p = p.next;
		}
		if (buffer.length() != 0) {
			buffer.deleteCharAt(buffer.length() - 1);
		}
		System.out.println(buffer.toString());
	}

}
