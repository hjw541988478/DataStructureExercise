package datastructure.exercise.tree.leetcode;

import datastructure.exercise.tree.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBTree {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max(root);
        return res;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = max(root.left);
        int right = max(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
