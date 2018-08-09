package 剑指offer.t41数据流中的中位数;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
class MedianNumberOfStream {
    /**
     * 思路：
     * 一、插入：
     * 插入的数，可能大于当前的最大值，也可能小于当前的最小值，所以需要先放入其中一个堆中，然后再放入另一个堆中。最后根据需要调整节点
     * 二、获取的中位数要么是两个堆顶元素之和除以2，要么就是二者其中的一个。
     * <p>
     * 注意的点：PriorityQueue 的使用
     */
    private PriorityQueue<Integer> minTopHeap = new PriorityQueue<>();//小顶堆，存放小的数字
    // Collections.reverseOrder() 返回一个逆向的 Comparator。
    // 内部实现其实很简单（假设对象可比较[也就是实现了 Comparable 接口]），
    // 就是将 java.util.Collections.ReverseComparator#compare
    // 方法内部实现从 o1.compareTo(o2) 修改为 o2.compareTo(o1);
    private PriorityQueue<Integer> maxTopHeap = new PriorityQueue<>(Collections.reverseOrder());//大顶堆。存放大的数字

    public void Insert(Integer num) {
        minTopHeap.offer(num);
        maxTopHeap.offer(minTopHeap.poll());//小顶堆中最小的数
        if (maxTopHeap.size() > minTopHeap.size()) {
            minTopHeap.offer(maxTopHeap.poll());
        }
    }

    public Double GetMedian() {
        if (maxTopHeap.size() == minTopHeap.size()) {
            return (maxTopHeap.peek() + minTopHeap.peek()) / 2.0;
        }
        return (double) minTopHeap.peek();
    }
}


class SolutionRecord {
    PriorityQueue<Integer> min = new PriorityQueue<>();//小顶堆，所有的数都大于 大顶堆中的所有数目
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());//大顶堆,任意元素都小于
    /*
    public void Insert(Integer num) {
        leetcode.sum++;

        if(leetcode.sum%2 ==0){//总数为偶数，放入小顶堆，先进行比较，
            //如果小于大顶堆的堆顶元素，先加入大顶堆，再摘取大顶堆的堆顶元素中插入到小顶堆中
            int tmp = maxHeap.peek();
            if(num < tmp){//要加入的元素小于大顶堆的堆顶元素
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }else{
                minHeap.offer(num);
            }
        }else{//总数为奇数，放入大顶堆
            int tmp = minHeap.peek();
            if(num > tmp){//要加入的元素大于小顶堆的堆顶元素
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }else{
                maxHeap.offer(num);
            }
        }
    }

    public Double GetMedian() {
        if(leetcode.sum == 0){
            return null;
        }
        if(leetcode.sum %2 == 0){
            return (maxHeap.peek()+minHeap.peek() )/2.0;
        }else{
            return maxHeap.peek() * 1.0;
        }
    }*/

    public void Insert(Integer num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        }
        return (double) max.peek();
    }

}
