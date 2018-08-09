package 剑指offer.t24反转链表;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


class ReverseList {
    /**
     * 输入一个链表，反转链表后，输出链表的所有元素。
     *
     * 思路：链表逆序本质上就是改变节点的指向。
     * 三个指针：newHead head next
     *
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     */
    public ListNode ReverseList(ListNode head) {
        //node  head
        //next
        ListNode newHead = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
