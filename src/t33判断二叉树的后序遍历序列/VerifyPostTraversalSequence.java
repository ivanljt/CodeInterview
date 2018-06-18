package t33判断二叉树的后序遍历序列;

/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
class VerifyPostTraversalSequence {
    /**
     * 思路：
     * 后序，根节点最后才会被遍历到。
     * 最后一个值作为分界。分别找出左子树的边界与右子树的边界
     * 然后再对左右子树进行区分
     * 当边界超出的时候，递归终止
     * 当前半部大于边界值的时候，return false
     * <p>
     * * 时间复杂度 O()
     * * 空间复杂度 O()
     */
    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootVal = sequence[end];
        int div = end - 1;//从倒数第二个元素开始往前
        //找出分界点
        while (div >= start && sequence[div] > rootVal) {
            div--;
        }
        //div 在左子树序列位于最后一个
        for (int i = start; i <= div; i++) {
            if (sequence[i] >= rootVal) {
                return false;
            }
        }
        return verify(sequence, start, div) //检查左子树序列
                && verify(sequence, div + 1, end - 1);//检查右子树序列
    }

    public static void main(String[] args) {
        int[] ary = new int[]{5, 8, 6, 15, 10};
        VerifyPostTraversalSequence verifyPostTraversalSequence = new VerifyPostTraversalSequence();
        boolean isPostSequence = verifyPostTraversalSequence.VerifySequenceOfBST(ary);
        System.out.println("isPostSequence " + isPostSequence);
        assert isPostSequence;

        ary = new int[]{8, 1, 2, 3};
        boolean isPostSequence2 = verifyPostTraversalSequence.VerifySequenceOfBST(ary);
        System.out.println("isPostSequence " + isPostSequence2);
        assert !isPostSequence2;
    }

}
