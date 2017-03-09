package me.huangjiawen.datasturcture.list.linked;

/**
 * 双向链表
 * 
 * @author huangjiawen
 *
 */
public class DoubleLinkedList<E> extends LinkedList<E>{

	@Override
	public boolean add(int position, E data) {
		/**
		 * s为带插入节点 p为前一节点
		 * 
		 * s-> prior = p;
		 * s-> next = p->next;
		 * p-> next -> prior = s;
		 * p-> next = s;
		 * 
		 */
		return false;
	}

	@Override
	public E remove(int position) {
		/**
		 * p为待删除节点
		 * 
		 * p->prior->next = p->next;
		 * p->next->prior = p->prior;
		 * free(p);
		 */
		return null;
	}

	@Override
	public E get(int position) {
		return null;
	}

	@Override
	public boolean print() {
		return false;
	}

}
