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
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] seq2 = Arrays.copyOf(nums, nums.length);
        System.out.println("before sort " + Arrays.toString(seq2));
        Arrays.sort(seq2);
        System.out.println("after sort " + Arrays.toString(seq2));
        int[][] result = new int[nums.length + 1][nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < nums.length + 1; j++) {
                if (nums[i - 1] == seq2[j - 1]) {//两个元素相同
                    if (j < seq2.length) {
                        if (seq2[j] > seq2[j - 1]) {//处理序列元素重复的情况「递增」
                            result[i][j] = 1 + result[i - 1][j - 1];
                        } else{
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

    public static void main(String[] args) {
        int[] ary = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = new LongestIncreasingSubSequence().lengthOfLIS(ary);
        System.out.println(result);
        //与 最长公共子序列不同的点在于 「递增」也就是序列中不允许重复
        ary = new int[]{2, 2};
        result = new LongestIncreasingSubSequence().lengthOfLIS(ary);
        assert result == 1;
        System.out.println(result);
    }
}
