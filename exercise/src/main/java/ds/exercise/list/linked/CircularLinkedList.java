package ds.exercise.list.linked;

/**
 * 循环链表
 *
 */
public class CircularLinkedList<E> extends LinkedList<E>{
	
	public void merge() {
		/**
		 *  rear为尾指针 
		 *  
		 *  p = rearA->next;
		 *  rearA->next = rearB ->next ->next;
		 *  rearB->next = p;
		 *  free(p);
		 *  
		 */
	}
}
