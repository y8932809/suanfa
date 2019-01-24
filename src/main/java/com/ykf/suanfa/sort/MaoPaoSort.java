package com.ykf.suanfa.sort;

import org.junit.jupiter.api.Test;

/**
 * @author yukf
 * @create 2018-09-19 10:36
 * @desc 冒泡排序
 **/
public class MaoPaoSort {
    @Test
    public void test() {
        int[] arr = {5, 2, 3, 1, 6, 9, 5};
        //最后一个位置一定是排序好的
        for (int i = 0; i < arr.length; i++) {
            //j < arr.length - 1 - i  这里减 i 是因为i的次数就是已经排好序的个数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "-");
        }
    }
}
