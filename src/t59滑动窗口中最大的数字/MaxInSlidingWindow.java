package t59滑动窗口中最大的数字;

import java.util.ArrayList;
import java.util.LinkedList;

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
     * 思路:使用一个队列（用其他的容器行不？可以的，一维线性的内容都 ok）
     * 队列的头部存储最大值的下标，
     * 每一趟循环中检查它是否过期，如果过期了，需要更新。然后当前窗口最大值就是 queue#peekFirst
     * <p>
     * 假设窗口大小为 size。从左到右遍历数组，
     * 判断过期的依据：queue#first < i -size + 1；
     * 判断是否添加到结果中的依据是：i >= size -1
     */

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        //[10,14,12,11],0
        if (num == null || size <= 0 || size > num.length) {//size <=0 或者
            return result;
        }
        LinkedList<Integer> queue = new LinkedList<>();//存储值在数组中的下标。
        //依次遍历所有滑动窗口。
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.getLast()] < num[i]) {//移除掉比当前元素小的数字
                queue.removeLast();
            }
            //添加当前元素
            queue.offerLast(i);//加进去如果发现太小了也无妨。因为后面会被移除掉
            //判断队首下标是否过期
            if (queue.getFirst() < i - size + 1) {
                queue.removeFirst();
            }
            if (i >= size - 1) {//添加到结果列表中
                result.add(num[queue.getFirst()]);
            }
        }
        return result;
    }

}

class SimpleImpl {

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