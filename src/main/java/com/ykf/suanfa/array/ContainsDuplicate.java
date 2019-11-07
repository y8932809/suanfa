package com.ykf.suanfa.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * 存在重复
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * @author yukaifei
 * @create 2019-11-07 19:54
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {9, 1,9};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}