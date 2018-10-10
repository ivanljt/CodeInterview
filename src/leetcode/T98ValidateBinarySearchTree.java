package leetcode;

import base.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 * */
class T98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * * 时间复杂度 O()
     * * 空间复杂度 O()
     * */
    //边界情况 [2147483647]，
    private boolean isValid(TreeNode root, long minVal, long maxVal) {//之所以定义为 long 类型，是为了处理节点的值为 Integer.MAX_VALUE,或者 Integer.MIN_VALUE 的情况
        if (root == null) {
            return true;
        }
        if (root.val <= minVal || root.val >= maxVal) {//必须在区间内
            return false;
        }
        return isValid(root.left, minVal, root.val)//验证左子树。值必须大于 Long.MIN_VALUE，小于根节点。左子树的后续遍历过程中，maxVal 为根节点的值，这就
                && isValid(root.right, root.val, maxVal);//验证右子树，值必须大于根节点，小于 Long.MAX_VALUE
    }
}

class SolRecord {
    /**
     * 错误的递归。
     * 无法处理
     * 10
     * /       \
     * 5        15
     * / \     /  \
     * nul nul 6   20
     * 的情况
     * 因为只检查跟父节点的关系
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val
                || root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
