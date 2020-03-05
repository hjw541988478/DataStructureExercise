package datastructure.exercise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraverse {

    public static void main(String[] args) {
        BinaryTreeTraverse treeTraverse = new BinaryTreeTraverse();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        List<Integer> res = new ArrayList<>();
//        treeTraverse.inOrderTraverse2(root, res);
//        System.out.println(res);
//        res = treeTraverse.postOrderTraverseIteration(root);
        System.out.println(treeTraverse.levelOrderTraverse(root));
    }

    public void preOrderTraverseRecursion(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preOrderTraverseRecursion(root.left, res);
            preOrderTraverseRecursion(root.right, res);
        }
    }

    public List<Integer> preOrderTraverseIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }

    public void inOrderTraverseRecursion(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrderTraverseRecursion(root.left, res);
            res.add(root.val);
            inOrderTraverseRecursion(root.right, res);
        }
    }

    public List<Integer> inorderTraverseIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public void postOrderTraverseRecursion(TreeNode root, List<Integer> res) {
        if (root != null) {
            inOrderTraverseRecursion(root.left, res);
            inOrderTraverseRecursion(root.right, res);
            res.add(root.val);
        }
    }

    public List<Integer> postOrderTraverseIteration(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            res.addFirst(root.val);
            if (root.left != null) {
                s.push(root.left);
            }
            if (root.right != null) {
                s.push(root.right);
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrderTraverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = q.poll();
                list.add(root.val);
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
