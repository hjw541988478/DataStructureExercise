package me.huangjiawen.datasturcture.queue;

/**
 * ֻ����һ�˽��в���һ�˽���ɾ�������Ա�
 */
public interface Queue<E> {
	public void enQueue(E data);

	public E deQueue();

	public int size();
	
	public void print();
}
