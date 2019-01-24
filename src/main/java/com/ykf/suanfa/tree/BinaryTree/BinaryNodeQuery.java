package com.ykf.suanfa.tree.BinaryTree;

/**
 * @author yukf
 * @create 2018-06-14 17:03
 * @desc
 **/
public class BinaryNodeQuery {

    public static void preOrder(BinaryNodeTree root) { // 先根遍历
        if (root != null) {
            System.out.print(root.data + "-");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void inOrder(BinaryNodeTree root) { // 中根遍历
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "--");
            inOrder(root.right);
        }
    }
    public static void postOrder(BinaryNodeTree root) { // 后根遍历
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "---");
        }
    }
}
