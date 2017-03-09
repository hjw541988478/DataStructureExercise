package me.huangjiawen.datasturcture.queue.sequential;

import me.huangjiawen.datasturcture.queue.Queue;

/**
 * 循环队列：首尾相接的顺序存储结构;
 *
 * 为了避免数组元素的插入和删除移动数据元素，引入队头和队尾，使得插入和删除操作复杂度由O(n)->O(1)
 */
public class CircularSequentialQueue<E> implements Queue<E> {
	public static final int MAX_SIZE = 10;

	Object[] queue;
	int front;
	int rear;

	public CircularSequentialQueue() {
		queue = new Object[MAX_SIZE];
		front = 0;
		rear = 0;
	}

	@Override
	public void enQueue(E data) {
		if (isQueueFull()) {
			return;
		}
		queue[rear] = data;
		rear = (rear + 1) % MAX_SIZE;
	}

	@Override
	public E deQueue() {
		E deleteData = null;
		if (isQueueEmpty()) {
			return null;
		}
		deleteData = (E) queue[front];
		front = (front + 1) % MAX_SIZE;
		return deleteData;
	}

	public boolean isQueueFull() {
		return (rear + 1) % MAX_SIZE == front;
	}

	public boolean isQueueEmpty() {
		return rear == front;
	}

	@Override
	public int size() {
		return (front - rear + MAX_SIZE) % MAX_SIZE;
	}

	@Override
	public void print() {
		int pFront = front;
		StringBuffer buffer = new StringBuffer();
		while (pFront != rear) {
			buffer.append(queue[pFront]).append(",");
			pFront = (pFront + 1) % MAX_SIZE;
		}
		buffer.deleteCharAt(buffer.length() - 1);
		System.out.println(buffer.toString());
	}

}
