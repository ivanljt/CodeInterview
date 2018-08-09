package 剑指offer.t68树中两个节点的最低公共祖先;


import base.TreeNode;

/**
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * */

/**
 * 求二叉树中两个节点的最低公共祖先节点。注意：二叉树 != 二叉搜索树。
 * 每个节点的值都是唯一的。
 * 如果输入的 p,q 中的一个 与 root 值相等，那么最低公共祖先为 p 或者 q。
 */
public class LowestAncestorOfTwoNodeInBinaryTree {

    /**
     * 思路：二叉树，不一定有序。所以不能像二叉搜索树那样通过值来判断。
     * 递归解法。深度优先遍历。
     * if both p and q exist in Tree rooted at root, then return their LCA
     * if neither p and q exist in Tree rooted at root, then return null
     * if only one of p or q (NOT both of them), exists in Tree rooted at root, return it
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {//递归终止条件
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {//左右子树都找到了「公共 root」，也就是左右子树包含了与 p，q 相等的节点。返回根节点
            return root;
        }
        return left != null ? left : right;//如果并不是right 可能为空
    }

}
