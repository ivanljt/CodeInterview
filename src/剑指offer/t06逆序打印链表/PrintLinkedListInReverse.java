package 剑指offer.t06逆序打印链表;

import java.util.ArrayList;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 * 思路：逆序 —> 可以借助数据结构：栈
 * —>或者是  List 的 add 方法
 *
 * 不要一开始考虑 链表自身的逆转。
 *
 * 其实返回值如果是链表的话。可能会更合适一点
 */
class PrintLinkedListInReverse {

    /**
     * 时间 O()
     * 空间 O()
     * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }


}
