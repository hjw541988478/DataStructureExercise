package datastructure.exercise.list.leetcode;

import datastructure.exercise.list.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedList {

    public ListNode mergeTwoListsByRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsByRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecursion(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsByIteration(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
