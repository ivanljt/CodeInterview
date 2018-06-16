package t树的遍历;

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
     * 迭代遍历
     */
    void inorderIter(TreeNode pRoot) {

    }

}
