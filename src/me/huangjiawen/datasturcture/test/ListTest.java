package me.huangjiawen.datasturcture.test;

import me.huangjiawen.datasturcture.list.List;
import me.huangjiawen.datasturcture.list.linked.LinkedList;
import me.huangjiawen.datasturcture.list.linked.StaticLinkedList;
import me.huangjiawen.datasturcture.list.sequential.SequentialList;

public class ListTest {
	public static void main(String[] args) {
		System.out.println("SequentialList------------------------------------------");
		List<Integer> seqList = new SequentialList<Integer>(new Integer[] { 1, 2, 3, 4, 5 });
		seqList.add(1, 7);
		seqList.add(0, 8);
		seqList.add(7, 9);
		seqList.add(7, 10);
		seqList.print();
		seqList.remove(2);
		seqList.print();
		seqList.get(2);
		seqList.print();
		System.out.println("\nLinkedList------------------------------------------");
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(0, 1);
		linkedList.add(1, 2);
		linkedList.add(2, 3);
		linkedList.add(3, 4);
		linkedList.add(4, 5);
		linkedList.print();
		linkedList.add(3, 8);
		linkedList.add(2, 9);
		linkedList.print();
		linkedList.remove(2);
		linkedList.remove(3);
		linkedList.print();
		System.out.println("position 2, dat:" + linkedList.get(2));
		linkedList.clear();
		linkedList.print();
		System.out.println("\nStaticLinkedList------------------------------------------");
		StaticLinkedList<Integer> staticList = new StaticLinkedList<Integer>();
		staticList.add(0, 1);
		staticList.add(1, 2);
		staticList.add(3, 9);
		staticList.add(2, 3);
		staticList.add(3, 4);
		staticList.add(4, 5);
		staticList.print();
		staticList.remove(2);
		staticList.print();
		staticList.add(2, 8);
		staticList.print();
		System.out.println("position 2, dat:" + staticList.get(2));

	}
}
