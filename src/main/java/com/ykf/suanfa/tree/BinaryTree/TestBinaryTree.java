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
        BinaryNodeTree root = new BinaryNodeTree(array[0]);   //创建二叉树
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]); //向二叉树中插入数据
        }
//        System.out.println("先根遍历：");/
//        BinaryNodeQuery.inOrder(root);  //9--10--17--28--35--39--56--65--87--
//        System.out.println();
          System.out.println("后根遍历：");
          BinaryNodeQuery.postOrder(root); //10---9---28---17---56---87---65---39---35---
    }
}
