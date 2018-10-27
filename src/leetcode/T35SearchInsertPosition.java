package leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
class T35SearchInsertPosition {
    /**
     * 思路：数组中没有重复的数字。二分查找
     * * 时间复杂度 O(lgN)
     * * 空间复杂度 O(1)
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            mid = left + ((right - left) >> 1);//注意位运算的优先级比较低，需要加上括号
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;

    }
}
