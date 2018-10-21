package leetcode;

import base.ListNode;

class T25ReverseNodesInKGroup {
    /**
     * ref:http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
     *
     * Reverse a link list between begin and end exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * begin       end
     * after call begin = reverse(begin, end)
     *
     * 0->3->2->1->4->5->6
     *          |  |
     *      begin end
     * @return the reversed list's 'begin' node, which is the precedence of node end
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;

    }

    /**
     * 翻转 begin ~ end 区间的节点
     */
    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }


    class Record {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            int count = k;
            ListNode p = head;
            while (count > 0 && p != null) {
                p = p.next;
                count--;
            }
            if (count > 0) {
                return head;
            }

            ListNode next = p.next;
            p.next = null;//切断

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            //头结点 《《  》》 尾结点；
            dummy.next = reverseNode(head);

            head.next = reverseKGroup(next, k);//重新连接

            return dummy.next;
        }

        ListNode reverseNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            ListNode newHead = null;
            while (next != null) {
                next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    }
}
