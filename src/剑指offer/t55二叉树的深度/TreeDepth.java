package 剑指offer.t55二叉树的深度;

import base.TreeNode;
/**
 * 题目：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 * */
class TreeDepth {

    /**
     * 思路：递归的方式获取左右子树的高度，比较大小，取较大的高度，+ 1（当前层）
     * 递归终止条：件到达空节点
     * * 时间复杂度 O()
     * * 空间复杂度 O(N)
     * */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);//左子树高度
        int right = TreeDepth(root.right);//右子树高度
        return Math.max(left, right) + 1;//取左右子树中较高者 + 1
    }
}
