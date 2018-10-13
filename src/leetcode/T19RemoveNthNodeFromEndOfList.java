package leetcode;

import base.ListNode;

class T19RemoveNthNodeFromEndOfList {
    //dummy  —>    1 —> 2 —> 3 —> 4 —> null    2
    //slow、fast   head
    //slow             fast
    //                 slow      fast
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);//之所以加一个 dummy，是为了处理输入只有一个节点的
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        //倒数的第 k 个节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 一个单链表中，想要移除的是倒数第 n 个节点，那么首先要找到倒数的第 n + 1 的节点，然后改变它的指向。
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     */
    //dummy —> 1 —> 2 —> 3 —> 4 —> null   1
    //p1、p2
    //p1            p2   （p2先走 n+1 步，二者之间的间隔为 n）
    //                   p1         p2       (齐驱并进)
    //删除 p1 的下一个节点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);//之所以加一个 dummy，是为了处理输入只有一个节点的
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = dummy;
        //从间隔的角度来看，second 与 first 之间有 n 个节点
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;//删除倒数第 n 个节点
        return dummy.next;
    }
}
