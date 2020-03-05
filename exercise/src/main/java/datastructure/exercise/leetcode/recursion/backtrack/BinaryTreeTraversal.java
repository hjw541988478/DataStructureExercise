package datastructure.exercise.leetcode.recursion.backtrack;

import datastructure.exercise.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeTraversal {

    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public List<Integer> inorderTraversalByIteration(TreeNode root) {
        List<Integer> res = new ArrayList();
        LinkedList<TreeNode> s = new LinkedList();
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.addLast(root);
                root = root.left;
            }
            root = s.removeLast();
            res.add(root.val);
            root = root.right;

        }
        return res;
    }

    public List<List<Integer>> levelOrderByBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    public List<List<Integer>> levelOrderByIteration(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> tmp = new ArrayList();
            for (int i = 0; i < sz; i++) {
                root = queue.removeFirst();
                tmp.add(root.val);
                if (root.left != null) {
                    queue.addLast(root.left);
                }
                if (root.right != null) {
                    queue.addLast(root.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

}
