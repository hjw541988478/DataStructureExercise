package datastructure.exercise.tree;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = new TreeNode(5);
        bst.insertByRecursion(root, 1);
        bst.insertByRecursion(root, 6);
//        bst.insertByIteration(root, 1);
//        bst.insertByIteration(root, 6);
        bst.print(root);
    }

    public void print(TreeNode root) {
        BinaryTreeTraverse binaryTreeTraverse = new BinaryTreeTraverse();
        System.out.println(binaryTreeTraverse.levelOrderTraverse(root));
    }

    public TreeNode insertByIteration(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    public TreeNode insertByRecursion(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        if (cur.val > val) {
            if (cur.left == null) {
                cur.left = new TreeNode(val);
            } else {
                insertByRecursion(cur.left, val);
            }
        } else if (cur.val < val) {
            if (cur.right == null) {
                cur.right = new TreeNode(val);
            } else {
                insertByRecursion(cur.right, val);
            }
        } else {
        }
        return root;
    }

    public TreeNode searchByIteration(TreeNode root, int key) {
        while (true) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
                return root;
            } else if (root.val > key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public TreeNode searchByRecursion(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return root;
        } else if (root.val > key) {
            return searchByRecursion(root.left, key);
        } else {
            return searchByRecursion(root.right, key);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode rightSmallet = root.right;
                while (rightSmallet.left != null) {
                    rightSmallet = rightSmallet.left;
                }
                rightSmallet.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
