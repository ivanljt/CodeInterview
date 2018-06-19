package t32从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

import base.TreeNode;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
class LevelZigZagPrint {
    /**
     * 思路：每一行的数据都存储在一个 ArrayList 中，需要从右到左打印的情况下，
     * 可以借助  list#add(int, T ) 方法
     *
     * * 时间复杂度 O(N)？
     * * 空间复杂度 O() 用到了不少容器工具类
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int toBePrint = 1;
        boolean fromLeft = true;//第一行 从 左 —> 右
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (fromLeft) {
                list.add(node.val);
            } else {
                list.add(0, node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            toBePrint--;
            if (toBePrint == 0) {//换行了
                result.add(list);
                list = new ArrayList<>();
                toBePrint = queue.size();
                fromLeft = !fromLeft;//顺序也要反过来了
            }
        }
        return result;
    }

}
