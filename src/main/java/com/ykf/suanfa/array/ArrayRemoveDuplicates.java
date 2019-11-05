package com.ykf.suanfa.array;

/**
 * @author yukf
 * @create 2018-10-10 14:28
 * @desc 数组去重
 **/
public class ArrayRemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int len = remove(arr);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 这道题的思路就是采用两个标记点 number 和 i ，
     * number记录不重复元素的位置，i从number的下一个开始遍历数组，
     * 如果i位置的数字等于number位置的数字，说明该数字重复出现，不予处理；
     * 如果i位置的数字不等于number位置的数字，说明该数字没有重复，需要放到i的下一位置，并使number加1。
     */
    public static int remove(int[] arr) {

        int numbers = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[numbers] != arr[i]) {
                numbers++;
                arr[numbers] = arr[i];
            }
        }
       return ++numbers;
    }
}
