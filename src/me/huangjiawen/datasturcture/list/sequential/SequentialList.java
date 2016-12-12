package me.huangjiawen.datasturcture.list.sequential;

import me.huangjiawen.datasturcture.list.List;

/**
 * ˳��洢���Ա�
 * 
 * �ŵ㣺 1.���ٴ�ȡĳһλ�õ�Ԫ��  2.����ΪԪ�ؼ���߼���ϵ���Ӷ���Ŀռ�
 * 
 * ȱ�㣺1.�����ɾ��Ԫ����Ҫ�ƶ�������Ԫ�� 2.���ڲ�ȷ��Ԫ�صĸ������ܲ������޷�ȷ����洢�ռ�����������¡���Ƭ���Ĳ���
 * 
 * @author huangjiawen
 *
 */
public class SequentialList<E> implements List<E> {
	public static final int MAX_SIZE = 100;
	Object[] listData;
	int listSize = 0;

	public SequentialList(E[] initData) {
		listData = new Object[MAX_SIZE];
		int i;
		for (i = 0; i < initData.length; i++) {
			add(i, initData[i]);
		}
	}

	@Override
	public boolean print() {
		StringBuilder sb = new StringBuilder("current list order:");
		for (int i = 0; i < listSize; i++) {
			sb.append(listData[i]).append(",");
			if (i == listSize - 1) {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		sb.append(" size:" + listSize);
		System.out.println(sb.toString());
		return true;
	}

	@Override
	public boolean add(int position,  E data) {
		int k = 0;
		if (listSize + 1 > MAX_SIZE) {
			return false;
		}
		if (position < 0 || position > listSize) {
			return false;
		}
		for (k = listSize - 1; k >= position; k--) {
			listData[k + 1] = listData[k];
		}
		listData[position] = data;
		listSize++;
		return true;
	}
	@Override
	public E remove(int position) {
		System.out.println("remove position:" + position);
		if (position < 0 || position > listSize - 1) {
			throw new IndexOutOfBoundsException("index is invalid , index :" + position +", size:" + listSize);
		}
		E removeData = (E) listData[position];
		for (int i = position; i < listSize - 1; i++) {
			listData[i] = listData[i + 1];
		}
		listSize--;
		return removeData;
	}

	@Override
	public E get(int position) {
		if (listSize < 1 || position < 0 || position > listSize - 1) {
			throw new IndexOutOfBoundsException("index is invalid , index :" + position +", size:" + listSize);
		}
		System.out.println("get " + position + " position data:" + listData[position]);
		return (E) listData[position];
	}

	@Override
	public int size() {
		return listSize;
	}


}