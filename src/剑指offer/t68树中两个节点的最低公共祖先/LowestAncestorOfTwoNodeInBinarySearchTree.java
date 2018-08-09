package 剑指offer.t68树中两个节点的最低公共祖先;


import base.TreeNode;

/**
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * */

/**
 * 二叉搜索树中两个节点的最低公共祖先节点。
 */
//如上所示，3，5 的最低公共祖先是 4
public class LowestAncestorOfTwoNodeInBinarySearchTree {
    //思路：如果是二叉**搜索**树，那么可以转换为查询问题
    //单看题目可能会想，是不是要从下往上找？
    //实际应该这么想：
    // 1.「树」是怎么样的一棵树？二叉树？还是普通树？
    // 2.「公共祖先」—>父节点。是否有指向父节点的指针？
    // 3. 最低
    //如果是二叉树的话—>利用它的性质，当前节点为 c， 给出的节点分别为 n1，n2
    //遍历的顺序从根节点开始，接下来应该往哪些方向走呢？
    //n1 n2 < c, 那么最低公共祖先可能在左子树，往左子树走
    //n1 n2 > c，右子树，右子树走
    //如果 n1< c< n2  、 n2 < c< n1，说明找到了。

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //注意：
        //每个节点的值都是唯一的。
        //如果输入的 p,q 中的一个 与 root 值相等，那么最低公共祖先为 p 或者 q
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;//左子树
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;//右子树
            } else {
                return root;
            }
        }
        return null;
    }

}
