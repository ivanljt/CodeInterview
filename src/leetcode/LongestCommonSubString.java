package leetcode;

/**
 * 问题：有两个字符串str和str2，求出两个字符串中最长公共子串长度。
 * 比如：str=acbcbcef，str2=abcbced，则str和str2的最长公共子串为bcbce，最长公共子串长度为5。
 *
 * 实践链接：https://www.nowcoder.com/questionTerminal/02e7cc263f8a49e8b1e1dc9c116f7602
 */
class LongestCommonSubString {
    /**
     * 思路：
     * 1、把两个字符串分别以行和列组成一个二维矩阵。
     * 2、比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为 result[i - 1][j - 1] + 1，否则设置为0。
     * 3、迭代过程中使用 maxLen 记录迭代至今的最大长度
     *
     * 可以参考 https://blog.csdn.net/u010397369/article/details/38979077
     **/
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        if (A == null || B == null || n <= 0 || m <= 0) {
            return 0;
        }
        int[][] result = new int[n + 1][m + 1];
//        //也可以使用一个 n*m 的数组，不过先初始化第一行，以及第一列
//        int[][] result = new int[n][m];
//        for (int i = 0; i < m; i++) {    //初始化二维矩阵中的第一行
//            result[0][i] = A.charAt(0) == B.charAt(i) ? 1 : 0;
//        }
//
//        for (int j = 1; j < m; j++) {    //初始化二维矩阵中的第一列
//            result[j][0] = B.charAt(0) == A.charAt(j) ? 1 : 0;
//        }
        int maxLen = 0;//保存当前最大长度
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {//注意
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = 0;
                }
                maxLen = Math.max(maxLen, result[i][j]);
            }
        }
        return maxLen;
    }
}
