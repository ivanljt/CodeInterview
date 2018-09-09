package leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 思路三：使用广度遍历优先的方式。发现当前的节点的左右子树为 null，说明该节点为叶子节点，此时的高度即为 最小高度
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(N)
     * */
    public int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        int nodeToPrint = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {//到达叶子节点,返回高度
                return depth;
            }
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);

            nodeToPrint--;
            if (nodeToPrint == 0) {//换行
                nodeToPrint = queue.size();
                depth++;
            }
        }
        return 0;
    }
}
