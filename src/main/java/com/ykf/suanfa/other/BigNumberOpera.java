package com.ykf.suanfa.other;

import org.junit.jupiter.api.Test;

/**
 * @author yukf
 * @create 2018-09-17 9:39
 * @desc 大数字运算
 **/
public class BigNumberOpera extends ClassLoader {
    @Test
    public void test() {
        System.out.println(156 % 10);
    }

    //阶乘
    public static void main(String[] args) {
        int[] nums = new int[100];
        nums[nums.length - 1] = 1;
        int operaNum=50; //阶乘数
        for (int i = 1; i <= operaNum; i++) {
            nums = demo(nums, i);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    private static int[] demo(int[] nums, int num2) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * num2;
        }
        //进留移位
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i - 1] += nums[i] / 10;
            nums[i] = nums[i] % 10;
        }
        return nums;
    }


    /**
     * 单数相乘
     */
    @Test
    public void opera() {
        int[] nums = new int[6];
        int num1 = 768;
        int num2 = 12;

        nums[nums.length - 1] = 8;
        nums[nums.length - 2] = 6;
        nums[nums.length - 3] = 7;

        //1、数组中的没个元素相乘
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * num2;
        }
        //进留移位

        for (int i = nums.length - 1; i > 0; i--) {
            nums[i - 1] += nums[i] / 10;
            nums[i] = nums[i] % 10;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }

    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return  null;

    }
}
