package me.huangjiawen.datasturcture.statck;

/**
 * ջ���޶����ڱ�β���в����ɾ�������Ա�(LIFO)
 * 
 * @author huangjiawen
 *
 */
public interface Stack<E> {
	E pop();
	void push(E data);
	E top();
	void clear();
	int size();
	void print();
}
