package com.ykf.suanfa.tree.BinaryTree;

/**
 * @author yukf
 * @create 2018-06-14 16:59
 * @desc
 **/
public class BinaryNodeTree {
    int data; //根节点数据
    BinaryNodeTree left; //左子树
    BinaryNodeTree right; //右子树

    public BinaryNodeTree(int data) { //实例化二叉树
        super();
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(BinaryNodeTree root, int data) {
        if (data > root.data) {
            //如果右子树为空，就插入，如果不为空就再创建一个节点
            if (root.right == null) {
                //就把插入的节点放在右边
                root.right = new BinaryNodeTree(data);
            } else {
                this.insert(root.right, data);
            }
        } else {
            //如果左子树为空，就插入，如果不为空就再创建一个节点
            if (root.left == null) {
                //就把插入的节点放在左边边
                root.left = new BinaryNodeTree(data);
            } else {
                this.insert(root.left, data);
            }
        }
    }
}


