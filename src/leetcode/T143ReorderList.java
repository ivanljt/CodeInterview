package leetcode;

import base.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * <p>
 * https://leetcode.com/problems/reorder-list/
 */
class T143ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        for (int i = 1; i < 4; i++) {
            ListNode node = new ListNode(i);
            prev.next = node;
            prev = node;
        }
        System.out.print("原链表为：");
        printList(head);
        reorderListSol(head);
        System.out.print("\n重排序之后的链表为：");
        printList(head);
    }

    private static ListNode printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        return head;
    }

    public static void reorderListSolutionRecord(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //1. 找到中间节点
        //2. 切断
        //3. 将后面的链表逆序
        //4. 交替插入节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {//「一次走两步」，避免空指针，先判空
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode newHead = null;//头插法 插入该链表
        ListNode next;
        while (mid != null) {
            next = mid.next;
            mid.next = newHead;
            newHead = mid;
            mid = next;
        }

        System.out.println(newHead.val);
        mid = newHead;

        ListNode l1 = head;
        ListNode l2 = newHead;

        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
        printList(head);
    }

    public static void reorderListSol(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //1. 找到中间节点
        //2. 切断
        //3. 将后面的链表逆序
        //4. 交替插入节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {//「一次走两步」，避免空指针，先判空
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode newHead = null;//头插法 插入该链表
        ListNode next;
        while (mid != null) {
            next = mid.next;
            mid.next = newHead;
            newHead = mid;
            mid = next;
        }

        ListNode l1 = head;
        ListNode l2 = newHead;

        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l1 = l1Next;
            l2.next = l1;
            l2 = l2Next;//往后移动一位
        }
    }
}
