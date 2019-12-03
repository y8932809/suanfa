package com.ykf.suanfa.array;

import java.util.*;

/**
 * 描述:
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author yukaifei
 * @create 2019-11-11 15:52
 */
public class Intersect {

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 2, 2, 4, 9};
        int[] nums3 = intersect(nums1, nums2);
        for (int i = 0; i < nums3.length; i++) {
            System.out.println(nums3[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            int searchIndex = list.indexOf(nums1[i]);
            if (searchIndex > -1) {
                resultList.add(nums1[i]);
                list.remove(searchIndex);
            }
        }
        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }

}