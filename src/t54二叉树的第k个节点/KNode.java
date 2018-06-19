package t54二叉树的第k个节点;

import java.util.Stack;

import base.TreeNode;

public class KNode {

    private int count = 0;

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

    //题目应该是「第 k 个」而不是「第 k 大」
    //中序遍历的第 k 个节点，
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        //迭代实现,每一次循环中，删除特定的节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                k--;
                if (k == 0) {
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }
}
