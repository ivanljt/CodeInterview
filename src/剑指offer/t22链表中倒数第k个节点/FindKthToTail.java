package 剑指offer.t22链表中倒数第k个节点;

import base.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
class FindKthToTail {

    /**
     * 「快慢指针」p1, p2。 先让 p2 走 k 步。
     * 如果这个时候 p2 为 null,说明长度小于 k，直接返回 null。
     * 否则，p1,p2 齐驱并进。一直到 p2 为 null。
     */
    //6,{1,2,3,4,5}  null
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (k > 0 && p2 != null) {
            p2 = p2.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
