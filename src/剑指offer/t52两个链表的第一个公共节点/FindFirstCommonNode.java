package 剑指offer.t52两个链表的第一个公共节点;

import java.util.Stack;

import base.ListNode;

/**
 * 两个链表的第一个公共节点。
 */
class FindFirstCommonNode {
    /**
     * 计算差值，然后齐驱并进
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        int c1 = 0;
        int c2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //计算长度
        while (p1 != null) {
            p1 = p1.next;
            c1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            c2++;
        }

        if (c1 > c2) {
            while (c1 > c2) {
                c1--;
                pHead1 = pHead1.next;
            }
        } else if (c1 < c2) {
            while (c1 < c2) {
                c2--;
                pHead2 = pHead2.next;
            }
        } else {
            return pHead1;
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1 == null ? null : pHead1.next;
            pHead2 = pHead2 == null ? null : pHead2.next;
        }
        return pHead1;
    }

    /**
     * 借助栈。先将所有的元素都放到Stack中，然后逐一比较，出栈，
     * 相当于是从尾到头的「遍历」
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (pHead1 != null) {
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode node = null;
        while (!s1.empty() && !s2.empty() && s1.peek() == s2.peek()) {
            s1.pop();
            node = s2.pop();
        }
        return node;
    }
}
