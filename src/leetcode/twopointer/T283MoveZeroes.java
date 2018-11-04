package leetcode.twopointer;

/**
 * 将数组中为0的数字都移动到后面去，需要保证其他元素的相对顺序。
 */
class T283MoveZeroes {

    /**
     * 因为只是要将 0 放到后面去，先将非 0 的数字逐一复制到前面，将后面的数字赋值为0。
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    class Record {
        /**
         * 错误的解法：
         * 无法处理 0,1,0 的情况
         */
        public void moveZeroes(int[] nums) {
            if (nums == null) {
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    //将后面的所有元素都往前移动一位。
                    //然后 0 给最后一位赋值为0
                    for (int j = i; j < nums.length - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    nums[nums.length - 1] = 0;
                }
            }
        }
    }
}
