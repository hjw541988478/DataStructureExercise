package datastructure.exercise.queue;

/**
 * 循环队列：首尾相接的顺序存储结构;
 * <p>
 * 为了避免数组元素的插入和删除移动数据元素，引入队头和队尾，使得插入和删除操作复杂度由O(n)->O(1)
 */
public class CircularArrayQueue<E> implements Queue<E> {
	public static final int MAX_SIZE = 10;

	Object[] queue;
	int head;
	int tail;

	public CircularArrayQueue() {
		queue = new Object[MAX_SIZE];
		head = 0;
		tail = 0;
	}

	@Override
	public void enqueue(E data) {
		if ((tail + 1) % MAX_SIZE == head) {
			return;
		}
		queue[tail] = data;
		tail = (tail + 1) % MAX_SIZE;
	}

	@Override
	public E dequeue() {
		E deleteData = null;
		if (empty()) {
			return null;
		}
		deleteData = (E) queue[head];
		head = (head + 1) % MAX_SIZE;
		return deleteData;
	}

	@Override
	public boolean empty() {
		return tail == head;
	}

	@Override
	public E peek() {
		return (E) queue[head];
	}

	@Override
	public int size() {
		return (tail - head + MAX_SIZE) % MAX_SIZE;
	}

	@Override
	public void print() {
		int pFront = head;
		StringBuffer buffer = new StringBuffer();
		while (pFront != tail) {
			buffer.append(queue[pFront]).append(",");
			pFront = (pFront + 1) % MAX_SIZE;
		}
		buffer.deleteCharAt(buffer.length() - 1);
		System.out.println(buffer.toString());
	}

}
