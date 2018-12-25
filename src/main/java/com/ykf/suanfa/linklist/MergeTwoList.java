package com.ykf.suanfa.linklist;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 合并两个有序链表
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author yukaifei
 * @create 2018-12-24 19:58
 */
public class MergeTwoList {


    public static void main(String[] args) {
        ListNode l1 = ListNode.CreateListNode("1,2,4");
        ListNode l2 = ListNode.CreateListNode("1,3,4");
        MergeTwoList mergeTwoList = new MergeTwoList();
        ListNode current = mergeTwoList.mergeTwoLists(l1, l2);
        while (current != null) {
            System.out.println(current.val + ",");
            current = current.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        List<Integer> result = new ArrayList<>();
//        while (l1.next != null || l2.next != null) {
//            if (l2 != null || l1.val < l2.val) {
//                result.add(l1.val);
//                l1 = l1.next;
//            } else {
//                result.add(l2.val);
//                l2 = l2.next;
//            }
//        }
//        System.out.println(JSON.toJSONString(result));
//        return null;
//    }


}