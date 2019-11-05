package com.ykf.suanfa.Array;

/**
 * 描述:给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @author yukaifei
 * @create 2019-07-02 16:40
 */
public class RotateArray {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate1(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 双重循环，依次移动最后一个元素到第一个位置，其余向后挪动
     */
    public static void rotate(int[] nums, int k) {
        while (k > 0) {
            int num = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            k--;
            nums[0] = num;
        }
    }

    /**
     * 这个方法基于这个事实：当我们旋转数组 k 次， k % n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
     * 假设 n=7n=7 且 k=3k=3 。
     * 使用反转
     * 原始数组                   : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     */

    public static void rotate1(int[] nums, int k) {
        k %= nums.length;
//        System.out.println("kkkk:" + k);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 另外一种方法
     * 将数组分为两部分，分为0——nums.size()-k-1和nums.size()-k——nums.size()-1;
     * 两部分分别反转，再整体反转，就能得到正确的结果。
     * 例子：[1,2,3,4,5,6,7] 和 k = 3 分为[1,2,3,4]和[5,6,7];分别反转后得到[4,3,2,1,7,6,5] 再整体反转得[5,6,7,1,2,3,4] 即为正确得结果
     */
}