package com.ykf.suanfa.linklist;

/**
 * @author yukf
 * @create 2018-10-22 10:24
 * @desc 删除链表
 **/
public class DeleteList {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode0 = new ListNode(0, listNode1);

        ListNode current = listNode0;
        delete(listNode2);

        while (current != null) {
            System.out.println(current.val + ",");
            current = current.next;
        }

    }

    /**
     * 1-2-3-4-5 如果删除2 ，则将3的val赋值给2的val，然后将2的next引用换成3的引用。
     * 也就是说把2的节点换成3，然后跳过3
     * @param listNode
     */
    private static void delete(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return;
        }
        listNode.val = listNode.next.val;
        listNode.next = listNode.next.next;
    }


}
