package ds.exercise.test;

import ds.exercise.queue.ArrayQueue;
import ds.exercise.queue.LinkedListQueue;
import ds.exercise.queue.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedListQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.print();
		queue.dequeue();
		queue.enqueue(8);
		queue.print();
		System.out.println("----------------------");
		queue = new ArrayQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.print();
		queue.dequeue();
		queue.enqueue(8);
		queue.print();
	}
}
