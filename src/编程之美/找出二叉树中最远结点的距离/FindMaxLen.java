package 编程之美.找出二叉树中最远结点的距离;

import base.TreeNode;

/**
 * leetCode 543.
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 * <p>
 *  1
 * / \
 * 2  3
 * /   \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class FindMaxLen {
    private int max;

    /**
     * 解法一：求出每个结点作为根结点时的最远距离
     * 不足，每一个节点都会重新计算高度，很多节点重复计算了。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getDepth(root.left);
        int rh = getDepth(root.right);
        diameterOfBinaryTree(root.left);//左子树的节点最远距离
        diameterOfBinaryTree(root.right);//右子树的节点最远距离
        max = Math.max(max, lh + rh + 1);
        return max - 1;
    }

    int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        return Math.max(l, r) + 1;
    }

    /**
     * 最优解：在获取树高度的时候，就可以根据情况更新值了
     * * 时间复杂度 O(N) 每一个节点我们访问一次
     * * 空间复杂度 O(N) 在深度优先遍历中，隐含的调用堆栈的大小。
     */
    private int ans = 1;

    public int diameterOfBinaryTree2(TreeNode root) {
        ans = 1;
        getD(root);
        return ans - 1;
    }

    int getD(TreeNode root) {
        if (root == null) return 0;
        int l = getD(root.left);
        int r = getD(root.right);
        ans = Math.max(ans, l + r + 1);//更新距离
        return Math.max(l, r) + 1;
    }
}
