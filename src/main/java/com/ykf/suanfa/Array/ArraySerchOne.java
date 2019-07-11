package com.ykf.suanfa.Array;

/**
 * 描述: 每个元素都有两个，只有一个元素是唯一的，例如 1、1、2、2、3
 * 注意：数组是无序的，空间复杂度 O1 时间复杂度 On
 * 数组查找唯一的元素
 *
 * @author yukaifei
 * @create 2019-07-11 15:14
 */
public class ArraySerchOne {

    public static void main(String[] args) {

        int[] a = {3, 1, 0, 1, 3, 0, 6};
        search(a);

    }

    public static void search(int[] numbers) {

        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("header:" + result + "-" + numbers[i]);
            result = result ^ numbers[i];
            System.out.println(result);
        }

    }
}