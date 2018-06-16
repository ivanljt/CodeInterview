package t54二叉树第k大;

import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class KNode {

    int count = 0;

    /**
     * 迭代方式。使用栈的解法。
     */
    //中序遍历，遍历完一个节点 count++。每一个函数中，实际上完成的是对「根节点」的遍历
    //最先被遍历的是「最左的叶子节点」(如果有的话)
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!stack.isEmpty()) {
                count++;
                TreeNode node = stack.pop();
                if (count == k) {
                    return node;
                }
                pRoot = node.right;
            }
        }
        return null;
    }
}
