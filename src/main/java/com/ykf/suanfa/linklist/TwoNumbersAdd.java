package com.ykf.suanfa.linklist;

/**
 * @author yukf1111
 * @create 2018-10-22 11:36
 * @desc 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 **/
public class TwoNumbersAdd {


    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode0 = new ListNode(0, listNode1);

        ListNode current = listNode0;
        addTwoNumbers(null, null);

        while (current != null) {
            System.out.println(current.val + ",");
            current = current.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }

}
