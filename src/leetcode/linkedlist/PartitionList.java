package leetcode.linkedlist;

import base.ListNode;

/**
 * Question：
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
class PartitionList {
    //创建两个指针分别存储 > x 和 <= x 的链表
    //遍历链表。如果节点值 >= x，存储在 left 链表，否则存储在 right 链表。
    //dummy left
    //dummy right
    //注意要切断右半部分的后续节点，否则可能会成环。比如：1—>3—>5—>6—>2 x = 5；
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(-1);
        ListNode left = dummyLeft;
        ListNode dummyRight = new ListNode(-1);
        ListNode right = dummyRight;

        // dummyLeft.next = head;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                left.next = p;
                left = left.next;
            } else {
                right.next = p;
                right = right.next;
            }
            p = p.next;
        }
        left.next = dummyRight.next;
        right.next = null;//切断后续节点，避免成环
        return dummyLeft.next;
    }
}
