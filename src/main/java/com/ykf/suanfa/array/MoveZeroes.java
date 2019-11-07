package com.ykf.suanfa.array;

/**
 * 描述:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author yukaifei
 * @create 2019-11-06 17:00
 */
public class MoveZeroes {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {1, 2, 0, 0, 5};
        moveZeroes2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int pos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}