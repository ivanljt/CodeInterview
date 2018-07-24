package t判断链表环;

import base.ListNode;

class EntryNodeOfLoop {


    /**
     * 一个一次走一步，另一个一次走两步。
     * 错误。最终相等的节点是在环内，但是不一定是起点。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //快慢指针。
        if (pHead == null) {
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;
        while (p1 != null && p2 != null && p1 != p2) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            if (p2.next == null) {
                return null;
            } else {
                p2 = p2.next.next;
            }
        }
        return p2;
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