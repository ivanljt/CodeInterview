package leetcode;

import base.TreeNode;

/**
 * 111.
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * */
class MinDepthOfTree {
    /**
     * 后序遍历的方式。
     * 左子树高度与右子树高度，求其中的小者
     * 因为是 从根节点到最近叶子节点的最短路径上的节点数量（而根据题目的定义，根节点不能作为叶子节点），所以当左子树或者右子树为空的时候，最小高度等于 非空子树的高度 + 1。
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return l == 0 || r == 0 ? l + r + 1 : Math.min(l, r) + 1;
    }

    /**
     * 另一种写法。如果有一棵子树为空，则「最小高度」取非空子树的最小高度
     * */
    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.right != null)
            return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
        else
            return Math.max(minDepth2(root.left), minDepth2(root.right)) + 1;//如果有一棵子树为空，则「最小高度」取非空子树的最小高度
    }
}
