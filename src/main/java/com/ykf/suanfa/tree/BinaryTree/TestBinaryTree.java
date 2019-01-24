package com.ykf.suanfa.tree.BinaryTree;

/**
 * @author yukf
 * @create 2018-06-14 14:57
 * @desc
 **/
public class TestBinaryTree {
    //https://blog.csdn.net/liaodehong/article/details/52767285
    public static void main(String[] args) {
        int[] array = {35, 17, 39, 9, 28, 65, 10,56, 87};
        //创建二叉树
        BinaryNodeTree root = new BinaryNodeTree(array[0]);
        for (int i = 1; i < array.length; i++) {
            //向二叉树中插入数据
            root.insert(root, array[i]);
        }
          System.out.println("后根遍历：");
          BinaryNodeQuery.postOrder(root);
    }
}
