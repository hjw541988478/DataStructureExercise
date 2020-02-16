package datastructure.exercise.queue;

/**
 * 只允许一端进行插入一端进行删除的线性表
 */
public interface Queue<E> {
	public void enqueue(E data);

	public E dequeue();

	public boolean empty();

	public E peek();

	public int size();

	public void print();
}
