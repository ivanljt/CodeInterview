package t树的遍历;

import java.util.Stack;

/**
 * 先打印根节点，再打印左子树，最后打印右子树
 */
class Inorder {
    /**
     * 递归遍历
     */
    void inorderRecursive(TreeNode pRoot) {
        if (pRoot == null) {//如果「根节点」为 null，直接返回。
            return;
        }
        inorderIter(pRoot.left);//左子树
        System.out.println(pRoot.val);//打印根节点的值
        inorderIter(pRoot.right);//右子树
    }

    /**
     * 迭代实现中序遍历。打印顺序:左子树  根节点  右子树
     * 1. 申请一个栈 stack，申请一个变量，初始时指向头节点
     * 2. 先把 current 压入栈中,对以cur节点为头的整棵子树来说，依次把整棵树的左边界压入栈中，也就是不断地令 cur = cur.left
     * 3. 不断重复2，直到发现 cur 为空，此时从 stack 中弹出一个节点，记为 node，打印 node的值，并让 cur = node.right，然后重复步骤 2
     * 4. stack 为空 & cur 为空时，整个过程结束
     */
    void inorderIter(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRoot != null) {//Stack 有两个判空方法，empty（自身提供）、isEmpty（从 vector 继承而来）

            while (pRoot != null) {//不断地将左子节点放入栈中，该循环结束时，栈顶部为「最左的叶子节点」
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            //pRoot 为 null 时,说明之前 已经到了「最左的叶子节点」
            pRoot = stack.pop();//弹出节点
            System.out.println(pRoot.val);//打印
            pRoot = pRoot.right;//指向当前节点的右子树（重复步骤2）
        }
    }
}
