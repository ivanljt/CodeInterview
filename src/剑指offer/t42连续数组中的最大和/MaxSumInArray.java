package 剑指offer.t42连续数组中的最大和;

import org.omg.CORBA.MARSHAL;

/**
 * 一个整数数组中的元素有正有负，在该数组中找出一个连续子数组，要求该连续子数组中各元素的和最大，这个连续子数组便被称作最大连续子数组。
 * 比如数组{2,4,-7,5,2,-1,2,-4,3}的最大连续子数组为{5,2,-1,2}，最大连续子数组的和为5+2-1+2=8。
 */
class MaxSumInArray {


    /**
     * 暴力解法。
     * 先从第一个元素开始向后累加，每次累加后与之前的和比较，保留最大值；
     * 再从第二个元素开始向后累加，以此类推。
     * <p>
     * * 时间复杂度 O(N^2)
     * * 空间复杂度 O()
     */
    public int FindGreatestSumOfSubArrayViolenly(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int curSum = 0;
            //从当前下标开始累加整个数组
            for (int j = i; j < array.length; j++) {
                curSum += array[j];//从
                max = Math.max(curSum, max);
            }
        }
        return max;
    }


    /**
     * max 记录当前读入的数据中最大的和。
     * curSum 记录当前数组中的最大值。
     * 遍历数据，根据情况更新这两个值
     * <p>
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     * <p>
     * 该算法的一个附带的有点是：它只对数据进行一次扫描，一旦元素被读入并被处理，它就不再需要被记忆。
     * 因此，如果数组在磁盘或磁带上，他就可以被顺序读入，在主存中不必存储数组的任何部分。不仅如此，在任意时刻，
     * 该算法都能对它已经读入的数据给出最大子数组的和（另外两种算法不具有这种特性）。具有这种特性的算法叫做联机算法。
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            max = Math.max(curSum, max);
            //如果累加和出现小于0的情况，
            //则和最大的子序列肯定不可能包含前面的元素，
            //这时将累加和置0，从下个元素重新开始累加
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return max;
    }

    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null) {
            return 0;
        }
        //如果前面的累积和小于0，抛弃掉。
        int current = 0;
        int maxSum = 0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (current <= 0) {
                current = array[i];
            } else {
                current += array[i];
            }

            if (current > maxSum) {
                maxSum = current;
            }
        }
        return maxSum;
    }
}
