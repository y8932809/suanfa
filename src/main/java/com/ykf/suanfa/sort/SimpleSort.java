package com.ykf.suanfa.sort;

import org.junit.jupiter.api.Test;

/**
 * @author yukf
 * @create 2018-09-18 10:15
 * @desc 简单排序
 **/
public class SimpleSort {
    @Test
    public void test() {
        int[] arr = {5, 2, 3, 1, 6, 9, 5};
        //最后一个位置一定是排序好的
        for (int i = 0; i < arr.length - 1; i++) {
            //记录最小元素的位置
            int k = i;
            //找出最小的元素
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    //保存最小的位置
                    k = j;
                }
            }
            //交换位置
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "-");
        }
    }
}
