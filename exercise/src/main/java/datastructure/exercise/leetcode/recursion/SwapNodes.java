package datastructure.exercise.leetcode.recursion;

import datastructure.exercise.list.LinkedNode;
import datastructure.exercise.list.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodes {

    public ListNode swapPairsByIteration(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = current.next.next;
        }
        return dummy.next;
    }

    public LinkedNode swapPairsByRecursion(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode secondNode = head.next;
        head.next = swapPairsByRecursion(secondNode.next);
        secondNode.next = head;
        return secondNode;
    }
}
