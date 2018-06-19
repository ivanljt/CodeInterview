package t32从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

import base.TreeNode;


/**
 * 题目：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
class LevelPrintBinaryTree {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int nextLevelLen = 1;
        int currentLen = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            currentLen++;
            TreeNode node = queue.pop();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (currentLen == nextLevelLen) {//要换行了
                currentLen = 0;
                nextLevelLen = queue.size();
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }

}