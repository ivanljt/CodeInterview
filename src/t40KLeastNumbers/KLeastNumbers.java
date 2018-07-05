package t40KLeastNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 * * 时间复杂度 O(n) n 为input数组的长度
 * * 空间复杂度 ~O(K)；优先队列，< 64的时候，扩容  >= 64 扩容1.5倍
 */
class KLeastNumbers {
    /**
     * 思路：
     * ①最简单粗暴的方法是对整一个数组排序，然后取前面 k 个数字。但是题目只要求找到「最小的 k 个数字」，没有要求这 k 个数是有序的
     * ②维护一个长度为 k 的「容器」，保存当前最小的 k 个数。「容器」可以是数组，也可以是java 集合框架中的类。
     * 每当有新元素进来的时候，就拿它跟「容器」里面的数字进行比较，如果小于「容器中最大的那个元素」，那么就将「最大」的元素给移除掉，将当前元素添加到容器中。
     * <p>
     * 在过滤的过程中，需要知道「容器」中最大的那个数，这样可以就不需要将容器内的所有元素都和当前元素进行比较了。
     * 如果大于最大的数字，直接忽略；否则删除最大的元素，并将 a 添加到「容器」中，然后重新调整容器中元素的顺序。
     *
     * 恰好满足上述条件的一种数据结构就是「优先队列」，调整仅需要 O(logN)的时间复杂度
     */
    //借助PriorityQueue 实现大顶堆，遍历元素做如下处理：假设当前元素为a，如果大于最大的数字，直接忽略；否则摘掉堆顶元素，并将a 添加到堆中
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//默认是小顶堆，期望的是大顶堆。需要自定义比较器。

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k <= 0 || input.length < k) {
            return result;
        }
        //首先往优先队列中添加 k 个元素
        for (int i = 0; i < k; i++) {
            pq.offer(input[i]);
        }
        //遍历元素并过滤
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