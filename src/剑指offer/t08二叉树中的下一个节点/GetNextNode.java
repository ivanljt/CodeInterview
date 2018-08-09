package 剑指offer.t08二叉树中的下一个节点;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 题目：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
class GetNextNode {
    /**
     * 思路：（做的时候，最好是画出一棵二叉树来）
     * 如果有右子树: ~~那么下一个节点就是右子树的根节点~~，错误。应该是右子树中最左的那个节点才对。
     * 如果没有右子树:
     *      是父节点的左子树，那么下一个节点是父节点
     *      不是父节点的左子树，第一个是左子节点是「当前节点」的节点。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //这里一开始搞错了，有右子树的情况下，下一个节点应该是，右子树中「最左的」那个节点。
        //一开始还以为是后面那段「寻找第一个左子节点是当前节点的节点」代码的判断逻辑有问题。
        //* 时间复杂度 O()
        //* 空间复杂度 O()
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //没有右子树
        //     if(pNode.next!=null && pNode == pNode.next.left){
        //         return pNode.next; //返回父节点
        //     }
        //
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {//当前节点是父节点的左子节点
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
