package me.huangjiawen.datasturcture.queue;

/**
 * 只允许一端进行插入一端进行删除的线性表
 */
public interface Queue<E> {
	public void enQueue(E data);

	public E deQueue();

	public int size();
	
	public void print();
}
