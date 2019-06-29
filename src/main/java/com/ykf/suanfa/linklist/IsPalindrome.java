package com.ykf.suanfa.linklist;

import java.util.List;

/**
 * 描述:请判断一个链表是否为回文链表。
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author yukaifei
 * @create 2019-06-29 15:57
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode l1 = ListNode.CreateListNode("1,2,4,2,1");
        System.out.println(isPalindrome(l1));
    }

    /**
     * 这个题虽然知道肯定是要反转链表，但是一直不知道怎么在空间复杂度为1的情况下做到，应该说不知道怎么找到中间点，然后看了别人的解题思路才意识到快慢指针的用法。
     * 快指针每次移动2格，慢指针每次移动一格，当快指针无法移动的时候，慢指针就到了中间点了。
     * 然后慢指针开始反转链表，完成以后就可以开始遍历了
     * 每次从慢指针完成后的结点拿出一个元素、从头结点拿出一个元素，如果相等就移动指针，否则返回False
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //1、利用快慢指针找到中间位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //2、反转后半段的链表
        ListNode cur = slow;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        //3、将反转的链表与前半段比较
        while (prev != null && head != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

}