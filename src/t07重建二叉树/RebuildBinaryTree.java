package t07重建二叉树;

// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * <p>
 */
public class RebuildBinaryTree {

    //思路：每次递归中确定一个值
    //前序，第一个元素是 根节点
    //中序，根节点把它们分开。
    //每一轮确定一个节点。（自上而下地构建二叉树）
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null
                || pre.length != in.length) {
            return null;
        }
        return recursiveConstruct(pre, 0, pre.length - 1,
                in, 0, in.length - 1);
    }

    private TreeNode recursiveConstruct(int[] pre, int preStart, int preEnd,
                                        int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preStart]);
        //迭代遍历，中序数组，查找根节点
        for (int i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                treeNode.left = recursiveConstruct(pre, preStart + 1, preStart + i - inStart,
                        in, inStart, i - 1);
                treeNode.right = recursiveConstruct(pre, preStart + i - inStart + 1, preEnd,
                        in, i + 1, inEnd);
                return treeNode;
            }
        }
        return null;
    }


}
