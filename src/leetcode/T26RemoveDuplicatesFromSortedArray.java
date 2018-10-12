package leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 */
class T26RemoveDuplicatesFromSortedArray {

    /**
     * 在有序数组中去重。
     * i 以及 i 之前的数字都是不重复的。
     * <p>
     * 维护两个指针，i j。
     * i 在前面，
     * 只要 nums[j] == nums[i] ，就增加 j，从而跳过重复值
     * 如果 nums[j] != nums[i], 需要将  nums[j] 复制给 nums[i+1]
     * <p>
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];//不重复的数字，移动到下一位去
                i++;
            }
        }
        return i + 1;//因为 i 是下标（从 0 开始），而这里要的是长度，所以需要 + 1
    }
}
