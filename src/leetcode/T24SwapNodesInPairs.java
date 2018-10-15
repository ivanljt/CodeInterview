package leetcode;

import base.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * <p>
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
class T24SwapNodesInPairs {
    /**
     * 递归解法：
     * 2     ->  1   ->  4   ->  3.
     * head     next
     * <p>
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(N)
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * 空值      2     ->  1   ->  4   ->  3.
     * dummy    head     second   newHead
     *  p
     * 迭代解法
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     */
    public ListNode swapPairsIterativeSol(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head != null && head.next != null) {//一趟循环中处理前后两个节点
            ListNode second = head.next;
            ListNode newHead = second.next;
            second.next = head;
            p.next = second;
            p = head;
            head = newHead;
        }
        p.next = head;
        return dummy.next;
    }
}
