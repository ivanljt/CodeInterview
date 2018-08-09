package 剑指offer.t26树的子结构;

import base.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
class SubStructureOfTree {

    /**
     * 思路：在 HasSubtree 函数中比较当前节点的值。如果相等，使用 isSubTree 函数比较左子树，如果左子树的结构一致，使用 isSubTree 函数比较右子树，否则返回 false。
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
            result = isSubTree(root1, root2);//从该节点开始比较比较整一棵树
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    /**
     * 思路：递归检验以 root1，root2 为根节点的两棵树是否一致。
     *  递归终止条件：当 root2 为 null 时，检查完毕，返回 true。当 root2为 null，root1 != null 的时候，返回 false；
     *
     *  先检验值是否相等，如果不相等，直接返回 false。如果相等，依次比较左右子树。
     * */
    boolean isSubTree(TreeNode root1, TreeNode root2) {
        //递归终止的条件
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {//当前节点
            result = isSubTree(root1.left, root2.left);//检查左子树
            if (result) {//左子树一致，比较右子树。检查结果
                result = isSubTree(root1.right, root2.right);//检查右子树
            }
        }
        return result;
    }
}
