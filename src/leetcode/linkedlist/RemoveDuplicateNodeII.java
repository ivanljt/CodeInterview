package leetcode.linkedlist;

import base.ListNode;

/**
 * 题目：Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * 给定一个排序链表，删除所有重复的元素每个元素 都不保留。
 */
public class RemoveDuplicateNodeII {
    public ListNode deleteDuplication(ListNode pHead) {//递归的解法
        //每一次递归中去掉一段重复的节点
        if (pHead == null || pHead.next == null) {//只剩下0个或者1个节点,就没有必要再判断去重了，前面的重复项（如果 有的话）都已经去掉了
            return pHead;
        }
        if (pHead.val == pHead.next.val) {
            int val = pHead.val;
            while (pHead != null && val == pHead.val) {
                pHead = pHead.next;
            }
            return deleteDuplication(pHead);
        } else {
            pHead.next = deleteDuplication(pHead.next);
        }
        return pHead;
    }
}
