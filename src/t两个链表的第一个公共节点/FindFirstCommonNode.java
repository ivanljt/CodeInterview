package t两个链表的第一个公共节点;

import java.util.Stack;

import base.ListNode;

class FindFirstCommonNode {

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
