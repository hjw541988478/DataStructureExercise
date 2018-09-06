package ds.exercise.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import ds.exercise.leetcode.twosum.ListNode;

public class MergeSortedList {
    //21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), res;
        res = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return res.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 23. Merge k Sorted Lists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode head = new ListNode(-1), res = head;
        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
            if (head.next != null) {
                queue.offer(head.next);
            }
        }
        return res;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode first = lists[0];
        for (int i = 1; i < lists.length; i++) {
            first = mergeTwoLists(first, lists[i]);
        }
        return first;
    }

    private ListNode mergeTwoLists4K(ListNode one, ListNode two) {
        ListNode res = new ListNode(-1), head = res;
        while (one != null && two != null) {
            if (one.val < two.val) {
                res.next = one;
                one = one.next;
            } else {
                res.next = two;
                two = two.next;
            }
            res = res.next;
        }
        if (one != null) {
            res.next = one;
        }
        if (two != null) {
            res.next = two;
        }
        return head.next;
    }
}
