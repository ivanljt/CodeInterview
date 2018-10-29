package leetcode.twopointer;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
class T209MinimumSizeSubarraySum {
    /**
     * 思路，双指针。外循环为 j，每一轮中都增加 nums[j]，一直到  从 i 到 j 的数字大于 s，只要满足条件，就更新 min 并且令 i 后移。
     * 1 2 3 4 5
     * i   j
     * <p>
     * * 时间复杂度 O(N*lgN)
     * * 空间复杂度 O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
//            while(sum< s){//一直到符合条件为止
            sum += nums[j];
            j++;
            //          }
            while (sum >= s) {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    static class SolRecord {
        /**
         * 读错题意了。题目中是>= 而不是 =
         * 不足：这种解法没有复用先前的结果，可以利用滑动窗口的思想
         * <p>
         * * 时间复杂度 O(N^2)
         * * 空间复杂度 O(1)
         */
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length <= 0) {
                return 0;
            }
            int minLen = Integer.MAX_VALUE;
            //[2,3,1,2,4,3] 7
            //正确结果为 2
            for (int i = 0; i < nums.length; i++) {//可能从任意位置开始
                int sum = 0;
                for (int j = 0; j < nums.length - i; j++) {
                    sum += nums[i + j];
                    if (sum >= s) {//找到其中的一个序列了 i i+1 。。 i+j
                        minLen = Math.min(j + 1, minLen);
                        break;
                    }
                }
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolRecord().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
