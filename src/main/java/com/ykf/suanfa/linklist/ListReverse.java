package com.ykf.suanfa.linklist;

/**
 * @author yukf
 * @create 2018-10-10 11:00
 * @desc 单链表反转
 **/
public class ListReverse {
    public static void main(String[] args) {
        ListNode listNode = ListNode.CreateListNode("1,2,3,4,5");
        ListNode current = reverse(listNode);
        while (current != null) {
            System.out.println(current.val + ",");
            current = current.next;
        }
    }
    private static ListNode reverse(ListNode listNode) {
        ListNode priv = null;
        ListNode current = listNode;
        while (current != null) {
            ListNode next = current.next;
            current.next = priv;
            priv = current;
            current = next;
        }
        return priv;
    }
}

