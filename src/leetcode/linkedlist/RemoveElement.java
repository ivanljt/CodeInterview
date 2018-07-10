package leetcode.linkedlist;

import base.ListNode;

/**
 * 问题
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 * 删除链表中等于给定值val的所有节点
 */
class RemoveElement {

    /**
     * 思路：当前节点—>下一个—>下下个
     * 插入一个头结点，方便处理 第一个节点就是待删除的节点的情况。
     * 如果节点是待删除的节点 node，令 cur#next —> cur#next#next。
     * 否则当前节点后移一位 cur = cur#next
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;//如果是要删除的值的，指向喜爱一个节点
            } else {
                cur = cur.next;//当前节点往后移
            }
        }
        return dummy.next;
    }
}
