package t树的遍历;

import java.util.Stack;

import base.TreeNode;

class Postorder {
    /**
     * 递归遍历方式
     */
    void postorderRecursive(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        postorderRecursive(pRoot.left);
        postorderRecursive(pRoot.right);
        System.out.println(pRoot.val);
    }

    /**
     * 双栈实现非递归后序遍历，
     * 1. 初始化两个栈，stack1，stack2. 先将根节点放入 stack1 中，
     * 2. 从 stack1 中弹出栈顶节点 node， 将 node 放入 stack2 中，
         * 如果 node 的左子节点不为空，将之放入 stack1 中，（因为后面会放到 stack2 中，而栈是先进后出的。 在 stack1 中先进后出 —> 进入到 stack2 中会提前打印出来）
         * 如果 node 的右子节点不为空，将之放入 Stack1 中
     * 3. 重复步骤2，一直到 stack1 为空，此时所有的节点都已经在 stack2 中，按序打印 stack2 中的节点，即可得到后序遍历序列
     */
    void postorderIter(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        while (!stack1.isEmpty()) {
            //每一个循环中，stack1中的一个节点node被弹出并添加到 stack2 中，  node的左右孩子被添加到了  stack1 中。（如果右孩子不为空，那么下一轮处理的就是 node 的右孩子）
            pRoot = stack1.pop();
            stack2.push(pRoot);
            if (pRoot.left != null) {
                stack1.push(pRoot.left);
            }
            if (pRoot.right != null) {
                stack1.push(pRoot.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }

}
