package ds.exercise.leetcode;

import ds.exercise.leetcode.twosum.ListNode;

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
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

    public static void main(String[] args) {
        SwapNodes demo = new SwapNodes();
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode reverseNode = demo.swapPairs(head);
        while (reverseNode != null) {
            System.out.print(reverseNode.val + ",");
            reverseNode = reverseNode.next;
        }
    }
}
