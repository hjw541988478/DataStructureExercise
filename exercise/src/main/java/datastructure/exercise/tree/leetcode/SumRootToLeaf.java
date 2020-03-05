package datastructure.exercise.tree.leetcode;

import datastructure.exercise.tree.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        prevSum = 2 * prevSum + root.val;
        if (root.left == null && root.right == null) {
            return prevSum; //leaf node return the sum until root
        }
        return dfs(root.left, prevSum) + dfs(root.right, prevSum);

    }
}
