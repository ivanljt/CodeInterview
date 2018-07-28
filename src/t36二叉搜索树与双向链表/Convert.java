package t36二叉搜索树与双向链表;

import base.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
class Convert {
    /**
     * 二叉树搜索树—>
     * 中序遍历的结果是有序的
     * 递归：
     * 每一轮中，转换好一个节点
     * <p>
     * 最开始返回的起始节点是，左子树中最左的叶子节点。它就是链表头。
     *
     * 因为左子树也可能为空，这种情况下，「最左边的」节点是 根节点
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        //处理左子树
        TreeNode leftHead = Convert(pRootOfTree.left);//这里那拿到的是转换后的链首，可能为 null
        //拿到左子树中「最右」的那个节点。也就是左子树中转换而成的链表的链尾。然后根据情况进行赋值
        if (leftHead != null) {
            TreeNode p = leftHead;
            while (p.right != null) {
                p = p.right;
            }
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        } else {
            pRootOfTree.left = null;
        }

        //-------------
        //处理右子树
        TreeNode rightHead = Convert(pRootOfTree.right);//这里那拿到的是转换后的链首，可能为 null
        if (rightHead != null) {
            rightHead.left = pRootOfTree;
        }
        pRootOfTree.right = rightHead;
        return leftHead == null ? pRootOfTree : leftHead;
    }
}
