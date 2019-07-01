package com.ykf.suanfa.linklist;

/**
 * 描述:给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * @author yukaifei
 * @create 2019-07-01 10:47
 */
public class CycleLinkList {

    public static void main(String[] args) {
        ListNode l1 = ListNode.CreateListNode("1,2,4,5");
        l1.next.next.next = l1.next;
        Boolean result = hasCycle(l1);
        System.out.println("是否有环：" + result);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}