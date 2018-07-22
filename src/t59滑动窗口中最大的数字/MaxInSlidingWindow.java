package t59滑动窗口中最大的数字;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * <p>
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
class MaxInSlidingWindow {

    /**
     * 思路:使用一个队列（用其他的容器行不？）队列的头部存储最大值的下标，检查它 是否过期，
     * 如果过期了，需要更新。 然后当前窗口最大值就是queue#peek
     * */


    /**
     * 直观的思路：遍历数组所有的滑动窗口。分别获取其中的最大值，加入到结果中。
     * 注意处理滑动窗口为 0,  滑动窗口大于数组长度 的情况
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> aryList = new ArrayList<>();
        if (size == 0 || size > num.length) {//滑动窗口为 0,  滑动窗口大于数组长度
            return aryList;
        }
        for (int i = 0; i < num.length - size + 1; i++) {
            aryList.add(getMaxAtWindow(num, i, i + size - 1));
        }
        return aryList;
    }

    /**
     * 计算给定范围中最大的那个数。
     */
    int getMaxAtWindow(int[] num, int start, int end) {
        int max = num[start];
        for (int i = start + 1; i <= end; i++) {
            if (max < num[i]) {
                max = num[i];
            }
        }
        return max;
    }
}
