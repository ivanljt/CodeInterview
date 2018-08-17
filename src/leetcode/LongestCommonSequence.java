package leetcode;

/**
 * 给定序列s1={1,3,4,5,6,7,7,8},s2={3,5,7,4,8,6,7,8,2}，
 * s1和s2的相同子序列，且该子序列的长度最长，即是LCS。
 * s1和s2的其中一个最长公共子序列是 {3,4,6,7,8}
 * <p>
 * 子串与子序列的区别：
 * 子序列：一个给定的序列的子序列，就是将给定序列中零个或多个元素去掉之后得到的结果。
 * 子串：给定串中任意个**连续的**字符组成的子序列称为该串的子串。
 */
class LongestCommonSequence {

    /**
     * 递归解法
     * 递归关系：
     * c[i,j]  =  0                         （i== 0，j == 0）
     * c[i,j]  =  c[i-1]+c[j-1]            (i,j>0 & xi == yj)
     * c[i,j] =  max(c[i,j-1),c[i-1,j])   (i,j>0 & xi != yj)
     * <p>
     * 利用上面的递归式，我们很容易就能写出一个计算 c[i,j] 的递归算法，
     */
    public int lcsRecursive(String A, int indexA, String B, int indexB) {
        if (A == null || B == null || indexA < 0 || indexB < 0) {
            return 0;
        }
        if (A.charAt(indexA) == B.charAt(indexB)) {
            return 1 + lcsRecursive(A, indexA - 1, B, indexB - 1);
        } else {
            return Math.max(lcsRecursive(A, indexA, B, indexB - 1),
                    lcsRecursive(A, indexA - 1, B, indexB));
        }
    }

    /**
     * 利用上面的递归式，我们将很容易就能写出一个计算 c[i,j] 的递归算法，
     * 但其计算时间是随输入长度指数增长的。由于在所考虑的子问题空间中，
     * 总共只有θ(m*n)个不同的子问题，因此，用动态规划算法自底向上地计算最优值能提高算法的效率。
     * <p>
     * 利用一个二维数组 result = new int[A.length()+1][B.length()+1] 将结果保存起来，从前往后计算，
     * result[A.length()][B.length()] 即为所求.
     *
     * * 时间复杂度 O(m*n)
     * * 空间复杂度 O(m*n)
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        int[][] result = new int[A.length() + 1][B.length() + 1];//数组是一个对象，其中的数据会默认初始化为零值
        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[A.length()][B.length()];
    }

    public static void main(String[] args) {
        LongestCommonSequence lcs = new LongestCommonSequence();
        String seqA = "bedaacbade";
        String seqB = "dccaeedbeb";
        int len = lcs.lcsRecursive(seqA, seqA.length() - 1,
                seqB, seqB.length() - 1);
        assert len == 5;

        //超时……
        seqA = "daabeddbcedeabcbcbec";
        seqB = "daceeaeeaabbabbacedd";

        int len2 = lcs.lcsRecursive(seqA, seqA.length() - 1,
                seqB, seqB.length() - 1);
        assert len2 == 10;

    }
}
