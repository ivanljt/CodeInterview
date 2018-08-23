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
     * <p>
     * 思路：链表逆序本质上就是改变节点的指向。
     * 三个指针：newHead head next
     *
     * 链表分为两个部分： 已经反转的部分(newHead) --  待反转的链表(head)
     * 每一趟循环中，处理一个节点（也就是 head 节点）的指向。然后 newHead 后移，head 后移
     * 循环前 newHead         head —>  next
     * 循环后 newHead    <-   head     next
     * <p>
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     */
    public ListNode ReverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = null;//初始情况下，已经反转好的链表头为 null。
        ListNode next = null;
        while (head != null) {
            next = head.next;//保存下一个节点
            head.next = newHead;//翻转
            newHead = head;
            head = next;//待反转的链表的链首指向 next
        }
        return newHead;
    }
}
