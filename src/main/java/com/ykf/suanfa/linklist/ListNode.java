package com.ykf.suanfa.linklist;

import java.util.List;

/**
 * @author yukf
 * @create 2018-10-22 10:24
 * @desc
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode current;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(){};

    public static ListNode CreateListNode(String listStr) {
        String[] listArr = listStr.split(",");
        ListNode head = null;
        ListNode prev = null;
        for (String item : listArr) {
            ListNode current = new ListNode(Integer.parseInt(item), null);
            if (head == null) {
                head = prev = current;
            } else {
                prev.next = current;
            }
            prev = current;
        }
        return head;
    }
}
