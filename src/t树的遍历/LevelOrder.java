package t树的遍历;

import java.util.LinkedList;
import java.util.Queue;

import base.TreeNode;

/**
 * 层序遍历
 */
class LevelOrder {
    void printTreeByLevel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
    }
}
