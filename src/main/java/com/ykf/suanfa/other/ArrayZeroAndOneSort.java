package com.ykf.suanfa.other;

/**
 * @author yukf
 * @create 2018-11-09 17:22
 * @desc 只含有0和1进行排序
 **/
public class ArrayZeroAndOneSort {

    public static void main(String[] args) {

        int[] a = {0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1};
        sort(a);
    }
    public static void sort(int[] numbers) {
        int j = numbers.length - 1;
        //一次遍历排序
        for (int i = 0; i < numbers.length; i++) {
            if (i >= j) {
                break;
            }
            if (numbers[i] == 1) {
                while (numbers[j] == 1) {
                    j--;
                }
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
    }
}
