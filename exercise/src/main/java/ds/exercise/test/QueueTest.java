package ds.exercise.test;

import ds.exercise.queue.Queue;
import ds.exercise.queue.linked.LinkedQueue;
import ds.exercise.queue.sequential.CircularSequentialQueue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new CircularSequentialQueue<Integer>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.print();
		queue.deQueue();
		queue.enQueue(8);
		queue.print();
		System.out.println("----------------------");
		queue = new LinkedQueue<Integer>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.print();
		queue.deQueue();
		queue.enQueue(8);
		queue.print();
	}
}
