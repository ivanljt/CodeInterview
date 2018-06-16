package t树的遍历;

class Postorder {
    /**
     * 递归遍历
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
     * 迭代遍历
     */
    void postorderIter() {

    }

}
