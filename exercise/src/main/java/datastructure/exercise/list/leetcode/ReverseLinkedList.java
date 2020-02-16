package datastructure.exercise.list.leetcode;

import datastructure.exercise.list.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    /**
     * Iterative way
     * time complexity: O(n)
     */
    public ListNode reverseListByIteration(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * time complexity: O(n)
     */
    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
