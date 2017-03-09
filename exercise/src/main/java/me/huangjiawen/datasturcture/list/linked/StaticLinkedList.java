package me.huangjiawen.datasturcture.list.linked;

import me.huangjiawen.datasturcture.list.List;

/**
 * 静态链表：
 *
 * 优点：1.利用顺序存储但插入删除只修改游标而不移动元素
 *
 * 缺点：1.失去了随机存储的特性 2.未解决连续存储分配不确定的问题
 * 
 * @author huangjiawen
 *
 */
public class StaticLinkedList<E> implements List<E> {

	public static final int MAX_SIZE = 100;

	public StaticLinkedNode<E>[] staticList;
	public int size;
	private int nextCursor = 0;

	public StaticLinkedList() {
		staticList = new StaticLinkedNode[MAX_SIZE];
		size = 0;

		for (int i = 0; i < MAX_SIZE - 1; i++) {
			staticList[i] = new StaticLinkedNode<E>();
			staticList[i].cursor = i + 1;
		}
		staticList[MAX_SIZE - 1] = new StaticLinkedNode<E>();
		staticList[MAX_SIZE - 1].cursor = 0;
	}

	private int getNextFreeCursor() {
		int freeCursor = nextCursor;
		nextCursor = staticList[freeCursor].cursor;
		return freeCursor;
	}

	private void recycleFreeCursor(int cursor) {
		staticList[cursor].cursor = nextCursor;
		nextCursor = cursor;
	}

	@Override
	public boolean add(int position, E data) {
		if (position < 0 || position > size) {
			return false;
		}
		System.out.println("add position: " + position + ", data:" + data);
		int j, k = MAX_SIZE - 1, l;
		j = getNextFreeCursor();
		staticList[j].data = data;
		for (l = 0; l < position; l++) {
			k = staticList[k].cursor;
		}
		staticList[j].cursor = staticList[k].cursor;
		staticList[k].cursor = j;
		size++;
		return true;
	}

	@Override
	public E remove(int position) {
		if (position < 0 || position > size) {
			return null;
		}
		System.out.println("remove position: " + position);
		int i, k = MAX_SIZE - 1;
		E removeData = null;
		for (i = 0; i < position; i++) {
			k = staticList[k].cursor;
		}
		i = staticList[k].cursor;
		removeData = staticList[i].data;
		staticList[k].cursor = staticList[i].cursor;
		recycleFreeCursor(i);
		size--;
		return removeData;
	}

	@Override
	public E get(int position) {
		E resultData = null;
		int i, k = MAX_SIZE - 1;
		for (i = 0; i < position; i++) {
			k = staticList[k].cursor;
		}
		resultData = staticList[staticList[k].cursor].data;
		return resultData;
	}

	@Override
	public boolean print() {
		int i, k = MAX_SIZE - 1;
		StringBuilder sb = new StringBuilder("current list order:");
		for (i = 0; i < size; i++) {
			k = staticList[k].cursor;
			sb.append(staticList[k].data).append(",");
			if (i == size - 1) {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		sb.append(" size:" + size);
		System.out.println(sb.toString());
		return true;
	}

	@Override
	public int size() {
		return size;
	}

}
