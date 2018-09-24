package leetcode;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
class t136SingleNumber {
    /**
     * 利用异或特有的算数属性，任何一个数字异或它自己都等于0，也就是说，如果从头到尾依次异或数组中的每一个数字，那么最终的结果刚好是那个只出现一次的数字，因为那些出现两次的数字全部在异或中抵消掉了。
     *
     * 初始一个值 temp为0，然后用它异或数组中的每一个值，最后的结果就是这个出现一次的数字。
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     * */
    public int singleNumber(int[] nums) {
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        return tmp;
    }
}
