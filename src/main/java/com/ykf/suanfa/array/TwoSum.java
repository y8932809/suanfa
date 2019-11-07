package com.ykf.suanfa.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * [-3,4,3,90]  0
 *
 * @author yukaifei
 * @create 2019-11-05 21:31
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {-3,4,3,90};
        int[] result = twoSum(nums, 0);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer getValue = map.get(target - nums[i]);
            if (getValue != null) {
                result[1] = i;
                result[0] = getValue;
            }
            map.put(nums[i], i);
        }
        return result;
    }


    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        List<Integer> opera = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = opera.indexOf(nums[i]);
            if (index > -1) {
                result[0] = index;
                result[1] = i;
            }
            opera.add(target - nums[i]);
        }
        return result;
    }
}