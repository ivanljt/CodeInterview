package leetcode.linkedlist;

import base.ListNode;

/**
 * 题目：Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 */
class RemoveDuplicateNode {
    /**
     * 思路：遍历f，遇到当前节点和下一节点的值相同时，删除下一节点，并将当前节点next值指向下一个节点的next,
     * 当前节点首先保持不变，直到相邻节点的值不等时才移动到下一节点。
     */
    ListNode removeDuplicateNode(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode curNode = node;
        while (curNode != null) {
            while (curNode.next != null && curNode.val == curNode.next.val) {
                //如果当前节点等于下一个节点，将下一个节点指向下下个节点
                curNode.next = curNode.next.next;
            }
            curNode = curNode.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        for (int i = 0; i < 5; i++) {
            if (i == 2 || i == 3) {
                cur.next = new ListNode(i - 1);
            } else {
                cur.next = new ListNode(i);
            }
            cur = cur.next;
        }
        printList(dummyNode);
        RemoveDuplicateNode removeDuplicateNode = new RemoveDuplicateNode();
        removeDuplicateNode.removeDuplicateNode(dummyNode);
        printList(dummyNode);
    }

    private static void printList(ListNode p) {
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

}
