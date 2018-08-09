package 剑指offer.t28对称的二叉树;

import base.TreeNode;

class IsSymmetrical {

    //思路：比较左右子树。
    //何谓对称：左子树的左子节点 == 右子树的右子节点； 左子树的右子节点 == 右子树的左子节点
    //如果相等，递归比较子节点；否则 return false
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    /**
     * 每一轮递归中， 比较一对节点，然后往下比较它们各自的左右子节点
     */
    boolean isSymmetrical(TreeNode pLeft, TreeNode pRight) {
        if (pLeft == null && pRight == null) {
            return true;
        }
        if (pLeft != null && pRight != null) {
            if (pLeft.val != pRight.val) {
                return false;
            }
            return isSymmetrical(pLeft.left, pRight.right)
                    && isSymmetrical(pLeft.right, pRight.left);
        }
        return false;
    }
}
