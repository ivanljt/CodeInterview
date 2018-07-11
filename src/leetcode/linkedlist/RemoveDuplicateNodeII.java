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

    /**
     * 迭代解法
     * 为了保证删除之后的链表仍然是相连的，要把当前节点的前一个节点（代码中的 pPreNode ）和后面的不重复的首节点相连
     */
    public ListNode deleteDuplicationIter(ListNode pHead) {
        if (pHead == null || pHead.next == null) {//只剩下0个或者1个节点,就没有必要再判断去重了
            return pHead;
        }
        ListNode pPreNode = null;
        ListNode pNode = pHead;

        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;

            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int value = pNode.val;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.val == value) {
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }

                //处理前节点，保证删除之后的链表仍然是相连的
                if (pPreNode == null) {
                    pHead = pNext;
                } else {
                    pPreNode.next = pNext;
                }
                pNode = pNext;
            }
        }
        return pHead;
    }
}
