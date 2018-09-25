package leetcode;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
class t137SingleNumber2 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {//32位
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {//遍历整一个数组
                if (((nums[j] >> i) & 1) == 1) {//如果当前数字的第 i 位为1，sum++, 如果当前位出现的次数能够被3
                    sum++;
                }
            }
            sum %= 3;//对3取模
            if (sum != 0) {//第 i 位已经计算完成了
                ans |= sum << i;//或操作
            }
        }
        return ans;
    }
}

class Record {
    public static void main(String[] args) {
        int result = new Record().singleNumber(new int[]{2, 2, 3, 2});
        System.out.println(result);
    }

    /**
     * 考虑到整形数字在电脑中存储的时候是四个byte，即32位bit，每一个数字都可以表示成一个32位的0 1 串，
     * 那么如果用一个32位的数组，记录数组中所有数字，每一位1出现的次数。然后每一位对3取余，
     * 数组中不为0的地方就是那一个只出现一次的数字的二进制中1的位置。
     */
    //错误。 输入 2 2 3 2； 结果为9，预期为3.需要先处理 bits[j] %= 3;
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                //这个数在第 j 位的值
                bits[j] += ((nums[i] >> j) & 1);
                bits[j] %= 3;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // if (bits[i] % 3 != 0) {
            result |= (bits[i] << i);//把记录的二进制他转化成整形数字
            //}
        }
        return result;
    }
}