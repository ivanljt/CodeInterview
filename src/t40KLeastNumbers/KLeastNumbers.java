package t40KLeastNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 * * 时间复杂度 O()
 * * 空间复杂度 O()
 */
class KLeastNumbers {
    //借助PriorityQueue 实现大顶堆，如果大于最大的数字，直接忽略，否则摘掉堆顶元素，然后
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());//默认是小顶堆，期望的是大顶堆。需要自定义比较器。

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input == null || k <= 0 || input.length < k) {
            return result;
        }
        for (int i = 0; i < k; i++) {
            pq.offer(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            if (pq.peek() > input[i]) {
                pq.poll();
                pq.offer(input[i]);
            }
        }

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}