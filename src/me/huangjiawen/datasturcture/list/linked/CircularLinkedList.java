package me.huangjiawen.datasturcture.list.linked;

/**
 * ѭ������
 *
 */
public class CircularLinkedList<E> extends LinkedList<E>{
	
	public void merge() {
		/**
		 *  rearΪβָ�� 
		 *  
		 *  p = rearA->next;
		 *  rearA->next = rearB ->next ->next;
		 *  rearB->next = p;
		 *  free(p);
		 *  
		 */
	}
}
