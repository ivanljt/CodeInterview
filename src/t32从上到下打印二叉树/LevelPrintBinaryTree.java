package t32从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

import base.TreeNode;


/**
 * 题目：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
class LevelPrintBinaryTree {
    /**
     * 队列，存储待打印的节点
     * 打印完每一行的尾部时，更新值
     *
     * * 时间复杂度 O(N)？
     * * 空间复杂度 O()
     * */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int lenToPrint = 1;//当前行待打印的节点总数。第一层只有一个。换行时更新
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            lenToPrint--;
            TreeNode node = queue.pop();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (lenToPrint == 0) {//要换行了
                String teet;
                lenToPrint = queue.size();
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }

}