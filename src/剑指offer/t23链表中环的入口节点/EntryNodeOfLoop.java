package 剑指offer.t23链表中环的入口节点;

import base.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
class EntryNodeOfLoop {
    /**
     * 快慢指针，环中相遇
     * 计算环的长度
     * 变为「倒数第 k 个节点的问题」
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;
//        一种循环方式。如果有环的话，
//        while (slow != fast && slow != null && fast != null && fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        while (fast != null && slow != null) {//
            if (fast == slow) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast != slow) {
                fast = fast.next;
            }
        }
        if (fast == null) {
            return null;
        }
        //计算环的大小
        int count = 1;
        ListNode p = slow.next;
        while (p != slow) {
            p = p.next;
            count++;
        }
        slow = pHead;
        fast = pHead;
        while (count-- > 0) {//先走 count 步。
            fast = fast.next;
        }

        //齐驱并进
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

/**
 * 断链法：
 * <p>
 * 两个指针，一个在前面，另一个紧邻着这个指针，
 * 在后面。两个指针同时向前移动，每移动一次，前面的指针的next指向NULL。
 * 也就是说：访问过的节点都断开，最后到达的那个节点一定是尾节点的下一个，
 * 也就是环的入口。 这时候已经是第二次访问循环的第一节点了，第一次访问的时候我们已经让它指向了NULL，
 * 所以到这结束。
 * <p>
 * * 时间复杂度 O(n)
 * * 空间复杂度 O(1)
 * <p>
 * 不足：
 * 修改了链表
 * 无法处理无环情况
 */
class CutNodeImpl {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead.next;
        ListNode slow = pHead;
        while (fast != null) {
            slow.next = null;
            slow = fast;
            fast = fast.next;
        }
        return slow;//返回的是 slow，而不是 fast。此时 fast 应该为 null
    }
}

/**
 * 公式计算推导
 * 可以省略两个步骤。
 */
class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        //先判断有没有环
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {//如果有环，那么二者永远都不会为 null
                fast = fast.next.next;
                slow = slow.next;
            } else {
                //没有环,返回
                return null;
            }
        }
        //循环出来的话就是有环，且此时fast==slow。
        fast = pHead;//指向链首，重头开始遍历。一次走一步。一直到 fast == slow
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}