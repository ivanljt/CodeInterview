package 剑指offer.t68树中两个节点的最低公共祖先;

/**
 * 求树中两个节点的最低公共祖先节点。
 */

import base.TreeNode;

/**
 *         _______6______
 *        /              \
 *     ___2__          ___8______
 *    /      \        /    \    |
 *    0      _4       7     9   11
 *          /  \
 *          3   5
 * */
//如上所示，3，5 的最低公共祖先是 4
public class LowestAncestorOfTwoNodeInTree {
    //思路：如果是二叉树，那么可以转换为查询问题
    //单看题目可能会想，是不是要从下往上找？
    //实际应该这么想：
    // 1.「树」是怎么样的一棵树？二叉树？还是普通树？
    // 2.「公共祖先」—>父节点。是否有指向父节点的指针？
    // 3. 最低

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }

}
