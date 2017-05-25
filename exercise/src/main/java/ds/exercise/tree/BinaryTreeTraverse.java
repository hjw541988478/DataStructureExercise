package ds.exercise.tree;

/**
 * Created by Administrator on 024 2017/5/24.
 */

public class BinaryTreeTraverse {

    int count = 0;
    BinaryThreadNode pre;

    public BinaryTreeNode createBinaryTree(BinaryTreeNode root, String[] strings) {
        if ("#".equals(strings[count])) {
            root = null;
        } else {
            root.data = strings[count];
            ++count;
            root.left = createBinaryTree(new BinaryTreeNode(), strings);
            ++count;
            root.right = createBinaryTree(new BinaryTreeNode(), strings);
        }
        return root;
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrderTraverse(BinaryTreeNode root) {
        if (root == null) {
            System.out.print("#");
            return;
        }
        System.out.print(root.data);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public void middleOrderTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        preOrderTraverse(root.left);
        System.out.println(root.data);
        preOrderTraverse(root.right);
    }

    public void postOrderTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
        System.out.println(root.data);
    }

    /**
     * 将普通的二叉树中序线索化
     *
     * @param root
     */
    public void inThreadingBinaryTree(BinaryThreadNode root) {
        if (root != null) {
            inThreadingBinaryTree(root.left);
            // 左指针为空，将左指针指向前驱
            if (root.left == null) {
                root.hasLeftPointer = true;
                root.left = pre;
            }
            // 前一节点的后继指向当前节点
            if (pre != null && pre.right == null) {
                pre.hasRightPointer = true;
                pre.right = root;
            }
            pre = root;
            inThreadingBinaryTree(root.right);
        }
    }

    /**
     * 遍历加了头节点的线索二叉树（时间复杂度大N）
     * 具体：
     * 1. 第一个访问的结点的前驱指向头结点
     * 2. 最后一个访问的结点的后继指向头结点
     * 3. 头结点的左指针指向根节点
     * 4. 头结点的右指针指向最后一个访问的结点
     *
     * @param root
     */
    public void threadBinaryTreeMiddleOrderTraverse(BinaryThreadNode root) {
        BinaryThreadNode p = root.left;
        while (p != root) {

            while (!p.hasLeftPointer) {
                p = p.left;
            }

            System.out.println(p.data);

            while (p.hasRightPointer && p.right != root) {
                p = p.right;
                System.out.println(p.data);
            }
            p = p.right;
        }

    }

    public static void main(String[] args) {
        BinaryTreeTraverse demo = new BinaryTreeTraverse();
        BinaryTreeNode root = demo
                .createBinaryTree(new BinaryTreeNode()
                        , new String[]{"A", "B", "#", "D", "#", "#", "C", "#", "#"});
        demo.preOrderTraverse(root);
    }
}
