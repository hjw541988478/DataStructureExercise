package ds.exercise.statck.linked;

import ds.exercise.list.linked.LinkedNode;
import ds.exercise.statck.Stack;

public class LinkedStack<E> implements Stack<E> {

	LinkedNode<E> stackTop;
	int count = 0;

	public LinkedStack() {
		stackTop = new LinkedNode<E>();
		stackTop.next = null;
	}

	@Override
	public E pop() {
		if (count < 1) {
			return null;
		}
		E removeData = stackTop.next.data;
		stackTop.next = stackTop.next.next;
		count--;
		return removeData;
	}

	@Override
	public void push(E data) {
		LinkedNode<E> newNode = new LinkedNode<E>();
		newNode.data = data;
		newNode.next = stackTop.next;
		stackTop.next = newNode;
		count++;
	}

	@Override
	public E peek() {
		return stackTop.next.data;
	}

	@Override
	public void clear() {
		while (stackTop.next != null) {
			LinkedNode<E> workNode = stackTop.next;
			stackTop = workNode.next;
			workNode = null;
		}
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void print() {
		StringBuilder strBuilder = new StringBuilder("current stack order:");
		LinkedNode<E> workNode = stackTop;
		while (workNode.next != null) {
			strBuilder.append(workNode.next.data).append(",");
			workNode = workNode.next;
		}
		strBuilder.deleteCharAt(strBuilder.length() - 1);
		strBuilder.append(" size:" + size());
		System.out.println(strBuilder.toString());
	}

}
