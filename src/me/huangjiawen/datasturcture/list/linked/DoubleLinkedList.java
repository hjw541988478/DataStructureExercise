package me.huangjiawen.datasturcture.list.linked;

/**
 * ˫������
 * 
 * @author huangjiawen
 *
 */
public class DoubleLinkedList<E> extends LinkedList<E>{

	@Override
	public boolean add(int position, E data) {
		/**
		 * sΪ������ڵ� pΪǰһ�ڵ�
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
		 * pΪ��ɾ���ڵ�
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
