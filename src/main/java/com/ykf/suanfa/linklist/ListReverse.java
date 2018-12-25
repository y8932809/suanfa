package com.ykf.suanfa.linklist;

/**
 * @author yukf
 * @create 2018-10-10 11:00
 * @desc 单链表反转
 **/
public class ListReverse {


    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNodeResult = reverse(listNode1);
        if (listNodeResult != null) {

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

    public void aa(ListNode listNode) {
        ListNode current = listNode;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

}

