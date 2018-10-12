package leetcode;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 */
class T27RemoveElement {

    /**
     * 遍历数组，如果当前值与目标值不相等，令 nums[index] = nums[i] 处，index++；
     * （因为在 length 之外的值不影响结果，所以直接复制走就行）
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                if (index != i) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return index;
    }
}
