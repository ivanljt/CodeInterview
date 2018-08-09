package leetcode.t对链表表示的数字求和;

import base.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumber {
    /**
     * 思路：循环遍历两个链表，处理 进位，当前节点，指针的更新
     * <p>
     * 时间复杂度 : O(max(m,n)). Assume that mm and nn represents the length of l1 and l2 respectively,
     * the algorithm above iterates at most max(m,n) times.
     * <p>
     * 空间复杂度 :O(max(m,n)). The length of the new list is at most max(m,n)+1.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;//指向 头结点。一开始想把 dummyHead.next 指向 cur，这样会增加很多额外的操作
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            l1 = l1 != null ? l1.next : null;//注意判空，避免 nullPointer
            l2 = l2 != null ? l2.next : null;//注意判空，避免 nullPointer
            int v = v1 + v2 + carry;//当前节点的值为 当前位置上的两个节点的和加上 前面节点的进位。
            carry = v / 10;//计算进位，两个个位数的和 < 20。进位要么0，要么为1.除以10 即可得出
            cur.next = new ListNode(v % 10);
            cur = cur.next;
        }
        if (carry != 0) {//如果最后还有一个进位
            cur.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
    // TODO: 2018/7/2 递归解法？

    public static void main(String[] args) {

    }
}