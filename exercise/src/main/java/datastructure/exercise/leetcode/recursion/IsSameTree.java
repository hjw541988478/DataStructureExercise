package datastructure.exercise.leetcode.recursion;

import datastructure.exercise.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val;
    }

    public boolean isSameTreeByIteration(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!check(p, q)) {
            return false;
        }
        Deque<TreeNode> pDeque = new ArrayDeque<>();
        Deque<TreeNode> qDeque = new ArrayDeque<>();
        pDeque.addLast(p);
        qDeque.addLast(q);
        while (!pDeque.isEmpty()) {
            p = pDeque.removeFirst();
            q = qDeque.removeFirst();
            if (!check(p, q)) {
                return false;
            }
            if (p != null) {
                if (!check(p.left, q.left)) {
                    return false;
                }
                if (p.left != null) {
                    pDeque.addLast(p.left);
                    qDeque.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    pDeque.addLast(p.right);
                    qDeque.addLast(q.right);
                }
            }
        }
        return true;
    }
}
