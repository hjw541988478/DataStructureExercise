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
        if (lower != null && root.x <= lower) {
            return false;
        }
        if (upper != null && root.x >= upper) {
            return false;
        }
        return isValidNode(root.left, lower, root.x) && isValidNode(root.right, root.x, upper);
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

            if (lower != null && cur.x <= lower) {
                return false;
            }
            if (upper != null && cur.x >= upper) {
                return false;
            }

            s.push(cur.left);
            l.push(lower);
            u.push(cur.x);

            s.push(cur.right);
            l.push(cur.x);
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
            if (min != null && root.x <= min) {
                return false;
            }
            min = root.x;
            root = root.right;
        }
        return true;
    }
}
