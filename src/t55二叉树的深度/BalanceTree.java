package t55二叉树的深度;

import base.TreeNode;

/**
 * 题目：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
class BalanceTree {

    /**
     * 平衡二叉树的定义：任意一个左右子树的高度差 <= 1
     * <p>
     * 「自上而下」递归解法：
     * 遍历二叉树的节点时，如果每个节点的左右子树的深度相差不过1，
     * 那么按照定义它就是一棵平衡树。
     * <p>
     * 缺点：这种方式会导致下面的节点被遍历多次。浪费计算性能。
     * 改进：修改遍历方式，「自下而上」地遍历节点，复用低层的节点结果
     * <p>
     * <p>
     * * 时间复杂度 O()
     * * 空间复杂度 O()
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (Math.abs(left - right) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        } else {
            return false;
        }
    }

    int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 优化的解法。
     * 「自下而上的递归解法」
     * 本质上是通过让 treeDepth 函数承担更多的职责来实现的
     */
    class OptimizedSolution {

        public boolean IsBalanced_Solution(TreeNode root) {
            //返回值不为-1，说明该节点的左右子树是平衡的。（如果不平衡会返回 -1）
            return treeDepth(root) != -1;//直接传根节点进去，而不是左右子节点，避免在该函数中做一些与 treeDepth 函数相同的判断逻辑。
            //       int left = treeDepth(root.left);
            //       if(left == -1){
            //           return false;
            //       }
            //       int right = treeDepth(root.right);
            //       if(right == -1){
            //           return false;
            //       }
            //     if(Math.abs(left-right) <= 1){
            //         return IsBalanced_Solution(root.left)//判断左子树是否平衡
            //             &&IsBalanced_Solution(root.right);
            //     }
            //     return false;
            //    return Math.abs(left-right) <= 1;
        }

        /**
         * 包含了两个功能，当发现不平衡的时候直接返回 -1，（上层也需要判断返回的结果是否为-1，如果是 -1 ，直接返回，避免不必要的运算）
         * 如果平衡，返回 树的高度
         */
        /**
         * treeDepth 函数中，用后序遍历的方式遍历整一颗二叉树，遍历左右节点，如果某一棵子树高度返回-1，则直接返回，否则，说明左、右子树 各自是平衡的，
         * 判断当前节点左右子树是否平衡，计算左右子树的高度差，如果是平衡的，则得到当前节点的深度，否则返回-1
         * 最后遍历到根节点的时候也就判断了整一棵二叉树的高度。
         * 关键是 treedepth 函数的职责不仅仅是是获取高度，还要判断左右子树的平衡情况。不平衡的情况下，直接返回避免不必要的计算
         */
        int treeDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = treeDepth(root.left);
            if (left == -1) {//不平衡直接返回 -1
                return -1;
            }
            int right = treeDepth(root.right);
            if (right == -1) {//不平衡直接返回 -1
                return -1;
            }
            if (Math.abs(left - right) > 1) {//高差超过 1，直接返回 -1，表示子树不平衡
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }
}
