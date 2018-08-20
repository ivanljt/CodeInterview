package leetcode;

import java.util.Arrays;

/**
 * 最长的递增序列
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
class LongestIncreasingSubSequence {

    /**
     * 思路1：
     * * 时间复杂度 O(N^2)
     * * 空间复杂度 O(N^2)  O((N+1)*(N+1))
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] seq2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(seq2);
        int[][] result = new int[nums.length + 1][nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {//注意边界条件是 <len + 1
            for (int j = 1; j < nums.length + 1; j++) {
                if (nums[i - 1] == seq2[j - 1]) {//两个元素相同
                    if (j < seq2.length) {
                        if (seq2[j] > seq2[j - 1]) {//处理序列元素重复的情况「递增」
                            result[i][j] = 1 + result[i - 1][j - 1];
                        } else {
                            result[i][j] = result[i - 1][j - 1];
                        }
                    } else {
                        result[i][j] = 1 + result[i - 1][j - 1];
                    }

                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(result));

        return result[nums.length][nums.length];
    }

    /**
     * 思路2：原数组的最长递增子序列必然是以原数组的某一个位置作为结尾。
     * 新建一个数组 dp，存储每一个元素作为「递增序列」结尾时的 LIS
     * 最坏的情况下，序列只包含自身，因此 dp[i]长度至少为1。
     * 从第一个元素开始，依次将各个元素作为「递增序列的末尾元素」，
     * 每次都遍历元素到末尾元素的左边界。 每一个小于当前 tail 的元素都可能是「递增序列中的倒数第二个数」，比较当前 tail 的 LIS 与 dp[j] 大小
     * <p>
     * dp 中的元素的大小由前面的元素以及它们对应的 LIS 决定
     * <p>
     * * 时间复杂度 O(N^2)
     * * 空间复杂度 O(N)
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;//第一个元素作为 增序序列的结尾，LIS =1
        for (int i = 1; i < nums.length; i++) {
            int tail = nums[i];
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (tail > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 根据 dp 数组生成 最长递增子序列.
     * 先遍历 dp 以获取 LIS len，以及 LIS 的末尾元素在数组中的下标 index。
     * 创建一个长度为 len 的数组。
     * <p>
     * 找出序列。倒数第二个元素满足： ary[i] < ary[index]  并且 dp[i] == len-1。令 result[--maxLen] = ary[i]
     * len--,index--,
     */
    int[] generateLis(int[] ary, int[] dp) {
        int maxLen = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                index = i;
            }
        }
        int[] result = new int[maxLen];
        result[--maxLen] = ary[index];
        //在 0..index 范围内查找LIS
        for (int i = index; i >= 0; i--) {
            if (ary[i] < ary[index] && dp[i] == maxLen - 1) {
                index = i;
                result[--maxLen] = ary[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ary = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int result = new LongestIncreasingSubSequence().lengthOfLIS2(ary);
        System.out.println(result);
        //与 最长公共子序列不同的点在于 「递增」也就是序列中不允许重复
        ary = new int[]{2, 2};

    }
}
