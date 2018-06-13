package t18删除链表中的节点;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 *
 * */
class DeleteAllDuplicateNode {
    /**
     * 递归思想。每一次递归中消除掉一组重复的数字。
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {//只有 0 个/ 1 个节点
            return pHead;
        }
        ListNode p = pHead;

        if (p.val == p.next.val) {//重复值
            int v = p.val;
            //先抛弃第一个重复值
            p = p.next;
            while (p != null && p.val == v) {//只要值重复，就一直往后
                p = p.next;
            }
            //走到这里，p.val ！= v
            return deleteDuplication(p);//
        } else {
            //没有发生重复，那么应该，head 保留
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}

