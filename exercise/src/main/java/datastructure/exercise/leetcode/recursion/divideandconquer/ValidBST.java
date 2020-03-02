package datastructure.exercise.leetcode.recursion.divideandconquer;

import datastructure.exercise.tree.TreeNode;

import java.util.LinkedList;

/*
   https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, null, null);
    }

    /**
     * divide and conquer
     */
    public boolean isValidNode(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        return isValidNode(root.left, lower, root.val) && isValidNode(root.right, root.val, upper);
    }

    LinkedList<TreeNode> s = new LinkedList();
    LinkedList<Integer> l = new LinkedList(), u = new LinkedList();

    /**
     * iterative way
     */
    public boolean isValidBST2(TreeNode root) {
        s.push(root);
        l.push(null);
        u.push(null);
        while (!s.isEmpty()) {
            TreeNode cur = s.poll();
            Integer lower = l.poll();
            Integer upper = u.poll();

            if (cur == null) {
                continue;
            }

            if (lower != null && cur.val <= lower) {
                return false;
            }
            if (upper != null && cur.val >= upper) {
                return false;
            }

            s.push(cur.left);
            l.push(lower);
            u.push(cur.val);

            s.push(cur.right);
            l.push(cur.val);
            u.push(upper);
        }
        return true;
    }

    LinkedList<TreeNode> st = new LinkedList();
    Integer min = null;

    /**
     * inorder traversal
     */
    public boolean isValidBST3(TreeNode root) {
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.poll();
            if (min != null && root.val <= min) {
                return false;
            }
            min = root.val;
            root = root.right;
        }
        return true;
    }
}
