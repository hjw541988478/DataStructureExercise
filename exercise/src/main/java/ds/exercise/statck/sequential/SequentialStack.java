package ds.exercise.statck.sequential;

import ds.exercise.statck.Stack;
public class SequentialStack<E> implements Stack<E> {

	private static final int MAX_SIZE = 100;

	private Object[] stack;
	private int top;

	public SequentialStack() {
		stack = new Object[MAX_SIZE];
		top = -1;
	}

	@Override
	public E pop() {
		if (top == -1) {
			return null;
		}
		return (E) stack[top--];
	}

	@Override
	public void push(E data) {
		if (top == MAX_SIZE - 1) {
			return;
		}
		++top;
		stack[top] = data;
	}

	@Override
	public E peek() {
		return (E) stack[top];
	}

	@Override
	public void clear() {
		while (top != -1) {
			pop();
		}
	}

	@Override
	public void print() {
		StringBuilder sb = new StringBuilder("current stack top to bottom:");
		int index = top;
		while (index != -1) {
			sb.append(stack[index--] + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(" size :" + size());
		System.out.println(sb.toString());
	}

	@Override
	public int size() {
		return top + 1;
	}

}
