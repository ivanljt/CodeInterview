package 剑指offer.t27二叉树的镜像;

import base.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 输入描述:
 * <p>
 * 二叉树的镜像定义：源二叉树
 * 8
 * /   \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * <p>
 * 镜像二叉树
 * 8
 * /    \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
class MirrorOfBinaryTree {
    /**
     * 思路：从根节点开始，自上而下地递归交换左右子树，一直到左右子树都为 null
     * */
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
