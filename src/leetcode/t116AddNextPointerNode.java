package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
 * and every parent has two children).
 * Example:
 * <p>
 * Given the following perfect binary tree,
 * <p>
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
class t116AddNextPointerNode {
    /**
     * 思路，使用层序遍历，每一层结尾的节点的 next 置为 null。
     * 层内部的节点 next 指针指向其同层的右边的节点，也就是queue.peek()
     */
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        int lenToPrint = 1;//当前层待打印的节点数目
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            lenToPrint--;
            if (lenToPrint == 0) {//换行
                node.next = null;
                lenToPrint = queue.size();
            } else {
                node.next = queue.peek();//null，队列首部
            }
        }
    }

    /**
     * 另一种换层的方式。利用 for 循环
     * */
    public void connectWay2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            int size = queue.size();
            //用这个for循环，可以保证for循环里面对queue不管加多少个子节点，我只处理当前层里面的节点
            for (int i = 0; i < size; i++) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i != size - 1) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }
            }
        }
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
