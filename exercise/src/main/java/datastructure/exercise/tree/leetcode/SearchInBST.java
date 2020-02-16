package datastructure.exercise.tree.leetcode;

import datastructure.exercise.tree.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.x == val) {
            return root;
        } else if (root.x > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
