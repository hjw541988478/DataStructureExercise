package me.huangjiawen.datasturcture.list.linked;

import me.huangjiawen.datasturcture.list.List;

/**
 * 链式存储线性表：
 *
 * 优点： 1.插入和删除元素时效率仅为O(1)
 *
 * 缺点：1.不连续的存储空间容易造成空间零碎
 * 
 * @author huangjiawen
 *
 */
public class LinkedList<E> implements List<E> {

	LinkedNode<E> headNode;
	int size;

	public LinkedList() {
		headNode = new LinkedNode<E>();
		headNode.data = null;
		headNode.next = null;
	}

	@Override
	public boolean add(int position, E data) {
		if (position < 0 || position > size) {
			throw new IndexOutOfBoundsException("index is invalid , index :" + position + ", size:" + size);
		}
		if (position == 0) {
			headAdd(data);
		} else if (position == size) {
			tailAdd(data);
		} else {
			System.out.println("middle add:" + data + " position:" + position);
			LinkedNode<E> workNode = headNode;
			int index = 0;
			while (index < position && workNode.next != null) {
				workNode = workNode.next;
				index++;
			}
			if (index == position && workNode != null) {
				LinkedNode<E> newNode = new LinkedNode<>();
				newNode.data = data;
				newNode.next = workNode.next;
				workNode.next = newNode;
			} else {
				System.out.println("add positon :" + position + " failed");
			}
		}
		size++;
		return true;
	}

	public boolean tailAdd(E data) {
		System.out.println("tail add:" + data);
		LinkedNode<E> lastNode = headNode;
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		LinkedNode<E> newNode = new LinkedNode<>();
		newNode.data = data;
		newNode.next = null;
		lastNode.next = newNode;
		return true;
	}

	public boolean headAdd(E data) {
		System.out.println("head add:" + data);
		LinkedNode<E> newNode = new LinkedNode<>();
		newNode.data = data;
		newNode.next = headNode.next;
		headNode.next = newNode;
		return true;
	}

	@Override
	public E remove(int position) {
		E removeData = null;
		int index = 0;
		LinkedNode<E> workNode = headNode;
		LinkedNode<E> deleteNode;

		while (index < position && workNode.next != null) {
			workNode = workNode.next;
			index++;
		}
		if (index == position && workNode != null) {
			deleteNode = workNode.next;
			removeData = workNode.next.data;
			workNode.next = deleteNode.next;
			deleteNode = null;
			size--;
		} else {
			System.out.println("delete positon :" + position + " failed");
		}
		return removeData;
	}

	@Override
	public E get(int position) {
		int index = 0;
		LinkedNode<E> firstNode = headNode;
		while (index < position + 1 && firstNode.next != null) {
			firstNode = firstNode.next;
			index++;
		}
		if (index == position + 1 && firstNode != null) {
			return firstNode.data;
		} else {
			System.out.println("get positon :" + position + " failed");
		}
		return null;
	}

	public void clear() {
		while (headNode.next != null) {
			LinkedNode<E> workNode = headNode.next;
			headNode = null;
			headNode = workNode;
			size--;
		}
	}

	@Override
	public boolean print() {
		LinkedNode<E> firstNode = headNode;
		StringBuilder sb = new StringBuilder("current list order:");
		while (firstNode.next != null) {
			firstNode = firstNode.next;
			sb.append(firstNode.data + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(" size:" + size);
		System.out.println(sb.toString());
		return true;
	}

	@Override
	public int size() {
		return size;
	}

}
