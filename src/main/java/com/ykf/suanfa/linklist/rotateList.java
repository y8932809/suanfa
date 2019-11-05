package com.ykf.suanfa.linklist;

/**
 * 描述:
 * 旋转链表
 *
 * @author yukaifei
 * @create 2019-07-13 14:00
 */
public class rotateList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.CreateListNode("1,2,3,4,5");
        ListNode current = rotateRight(listNode, 2);
        while (current != null) {
            System.out.println(current.val + ",");
            current = current.next;
        }
    }

    public static ListNode reverseList(ListNode list, int k, int f) {
        ListNode prev = null;
        ListNode current = list;
        while (current != null) {
            ListNode next = current.next;
//            if (f == 1) {
//                if (k <= 0) {
//                    return prev;
//                }
//            }
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode rotateRight(ListNode head, int k) {

        ListNode listNode = reverseList(head, 0, 0);

        return listNode;

    }

}