package t树的遍历;

class Preorder {
    /**
     * 递归遍历
     */
    void preorderRecursive(TreeNode pRoot) {
        if (pRoot == null){
            return;
        }
        System.out.println(pRoot.val);
        preorderRecursive(pRoot.left);
        preorderRecursive(pRoot.right);
    }

    /**
     * 迭代遍历
     */
    void preorderIter() {

    }

}
