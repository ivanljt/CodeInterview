package 剑指offer.t35复杂链表的复制;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CopyRandomListNode {
    /**
     * 思路：
     * 分三步走：
     * 首先复制每一个节点到自己的后面。
     * 设置指针，
     * 遍历分割
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        cloneNode(pHead);
        cloneRandom(pHead);
        return split(pHead);
    }

    void cloneNode(RandomListNode pHead) {
        while (pHead != null) {
            RandomListNode next = pHead.next;
            pHead.next = new RandomListNode(pHead.label);
            pHead.next.next = next;
            pHead = next;
        }
    }

    void cloneRandom(RandomListNode pHead) {
        while (pHead != null) {
            //注意：复制出来节点的 random 指针指向的是 random.next
            pHead.next.random =
                    pHead.random == null ? null : pHead.random.next;
            pHead = pHead.next.next;
        }
    }

    RandomListNode split(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode h2 = pHead.next;
        RandomListNode cur = h2;
        while (pHead != null) {
            pHead.next = cur.next;
            pHead = pHead.next;
            if (pHead != null) {
                cur.next = pHead.next;
                cur = cur.next;
            }
        }
        return h2;
    }
}

class Solution2 {
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        cloneNode(pHead);//复制节点，链接到每一个原节点的后面
        cloneRandom(pHead);
        return split(pHead);
    }

    void cloneNode(RandomListNode pHead) {
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode clone = new RandomListNode(p.label);
            clone.next = p.next;

            p.next = clone;
            p = clone.next;//指向下下个节点，直接用 clone.next 就能拿到
        }
    }

    void cloneRandom(RandomListNode pHead) {
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode clone = p.next;
            clone.random = p.random == null ? null : p.random.next;

            p = clone.next;
        }
    }

    RandomListNode split(RandomListNode pHead) {
       /* if(pHead == null||pHead.next == null){
            return null;
        }*/

        //初始化
        RandomListNode p = pHead;
        RandomListNode cHead = p.next;
        RandomListNode cNode = p.next;
        p.next = cNode.next;
        p = p.next;
        // A      A'     B     B'     C     C'     D     D'
        //      cNode    p
        // head   cHead
        while (p != null) {
            cNode.next = p.next;
            cNode = cNode.next;
            p.next = cNode.next;
            p = p.next;
        }
        return cHead;
    }
}