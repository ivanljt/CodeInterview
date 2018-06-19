package t树的遍历;

import java.util.Stack;

import base.TreeNode;

class Preorder {
    /**
     * 递归遍历
     */
    void preorderRecursive(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        System.out.println(pRoot.val);
        preorderRecursive(pRoot.left);
        preorderRecursive(pRoot.right);
    }

    /**
     * 迭代方式进行中序遍历。
     * 初始状态下，将根节点添加到栈中
     * 每一次循环中，打印一个节点之后 把该节点的「右子树的根节点」以及 「左子树的根节点」放到栈中
     */
    void preorderIter(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        TreeNode cur;
        while (!stack.empty()) {
            cur = stack.pop();
            System.out.println(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

}
