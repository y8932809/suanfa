package com.ykf.suanfa.linklist;

/**
 * @author yukf
 * @create 2018-11-02 16:49
 * @desc 删除链表的倒数第N个节点
 **/
public class RemoveFromEnd {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode current = removeNthFromEnd(listNode1, 1);

        while (current != null) {
            System.out.println(current.val + ",");
            current = current.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode current = head;
        //先让第一个指针后移n个节点
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        //如果要删除第一个节点，那么直接返回第一个节点后面的节点就可以
        if (current == null) {
            return prev.next;
        }
        //两个指针同事向后移，直到头指针直到最后一个为止
        while (current.next != null) {
            current=current.next;
            prev=prev.next;
        }
        //当头节点到达最后一个位置时，那第二个节点一定会和头节点相隔n个位置，也就是说这时
        //第二个节点的下一个节点就是要删除的。
        prev.next=prev.next.next;
        return head;
    }
}
