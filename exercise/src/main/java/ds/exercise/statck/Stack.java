package ds.exercise.statck;

/**
 * 栈：限定仅在表尾进行插入或删除的线性表(LIFO)
 * 
 * @author huangjiawen
 *
 */
public interface Stack<E> {
	E pop();
	void push(E data);
	E peek();
	void clear();
	int size();
	void print();
}
