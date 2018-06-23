package t34二叉树中和为某一值的路径;

import java.util.ArrayList;

import base.TreeNode;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
class FindPath {

    ArrayList<Integer> mPath = new ArrayList<>();
    ArrayList<ArrayList<Integer>> mResult = new ArrayList<>();


    /**
     * //「回溯思想」
     * 前序遍历的方式遍历节点。访问到某个节点的时候，就将该节点添加到路径上，并累加该节点的值，
     * 如果该节点为叶节点，并且路径中节点值的和刚好与目标值相等，
     * <p>
     * 注意：函数退出前需要在路径上删除当前节点并减去当前节点的值
     *
     * * 时间复杂度 O()
     * * 空间复杂度 O()
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return mResult;
        }
        mPath.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {//满足条件
            mResult.add(new ArrayList<>(mPath));
            mPath.remove(mPath.size() - 1);
            return mResult;//mResult 是「成员变量」，整个函数没有对返回值做特殊判断
        }
        if (target > 0) {
            if (root.left != null) {
                FindPath(root.left, target);
            }
            if (root.right != null) {
                FindPath(root.right, target);
            }
        }
        mPath.remove(mPath.size() - 1);
        return mResult;
    }
}
