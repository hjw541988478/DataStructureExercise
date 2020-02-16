package datastructure.exercise.tree;

/**
 * Created by Administrator on 024 2017/5/24.
 */

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
