package leetcode.linkedlist;


import java.util.ArrayList;
import java.util.List;

import base.ListNode;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * 查找单链表的中间节点。
 */
class FindMiddleNode {

    /**
     * 粗暴的方式：遍历链表计算出长度 l。
     * count = l/2
     * 再次遍历链表。遍历一个节点 count--，count减到0的时候，到达中间节点
     * * 时间复杂度 O(3/2N)
     * * 空间复杂度 O(1)
     * */

    /**
     * 借助辅助空间 ArrayList
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(N)
     */
    public ListNode middleNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }


    /**
     * 快慢指针。 fast，slow
     * slow 一次走一步，fast 一次走两步。
     * 当 fast 走到尾部的时候，slow 指向的节点就是中间节点
     * 当长度为奇数的时候，返回中间节点，当长度为偶数的时候，返回第2个中间节点 即 l/2+1
     * 也就是：
     * slow 1，2，3，4
     * fast 1，3，5，7
     * 如果是要求返回「第一个中间节点的话」
     * slow 1，2，3，4
     * fast 2，4，6，8 或者是 null
     * <p>
     * * 时间复杂度 O(N/2)
     * * 空间复杂度 O(1)
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
