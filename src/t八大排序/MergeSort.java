package t八大排序;

/**
 * 要将一个数组排序，可以先（递归地）把它分成两部分，分别排序，然后将结果归并起来。
 * <p>
 * 优点： 将任意长度为N的数组排序所需时间和NlogN成正比
 * 缺点：所需的额外空间和N成正比
 * <p>
 * <p>
 * 快速排序与归并排序比较：
 * Q:为什么数组排序时更多使用快速排序而不是归并排序？
 * A:快排不需要额外的存储空间。堆排需要 O(N) 的空间。
 * 分配以及释放内存会增加运行时间。
 * <p>
 * Q:为什么链表排序时为什么更多是用归并排序而不是快排。
 * A:链表中可以用 O(N) 时间、空间复杂度，往中间插入 items
 * 不需要额外的内存分配。
 * <p>
 */
public class MergeSort {

    /**
     * 递归版。
     */
    void mergeSort(int[] ary, int[] result, int start, int end) {
        if (start >= end) {//递归终止条件。只剩一个元素的时候
            return;
        }
        int mid = start + ((end - start) >> 1);//右移一位
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSort(ary, result, start1, end1);
        mergeSort(ary, result, start2, end2);
        int k = start;//每一轮排序中，合并两个有序的数组。从它们的起始位开始
        while (start1 <= end1 && start2 <= end2) {//升序，小的在前面
            result[k++] = ary[start1] <= ary[start2] ? ary[start1++] : ary[start2++];
        }
        while (start1 <= mid) {
            result[k++] = ary[start1++];
        }
        while (start2 <= end) {
            result[k++] = ary[start2++];
        }
        //将结果复制回原数组。因为过程中，每一轮结束，都会将两个有序的子数组—>一个有序的子数组
        for (int i = start; i <= end; i++) {
            ary[i] = result[i];
        }
    }

    /**
     * 迭代版。「自底向上」的排序。
     * 通过外循环，控制好每一轮归并数组的长度。
     * 内循环中控制归并的范围
     */
    public int[] mergeSort(int[] array, int n) {
        // write code here
        if (array == null || n <= 1) {
            return array;
        }
        int[] result = new int[n];
        for (int size = 1; size < n; size *= 2) {//尺寸为1，2，4，8……
            for (int start = 0; start < n; start += 2 * size) {
                int end = Math.min(start + 2 * size, n);
                int mid = Math.min(start + size, n);//换一种计算方式
                //两个块的起始下标及结束下标
                int start1 = start, end1 = mid;
                int start2 = mid, end2 = end;//start2 = mid 而不是 mid+1；避免越界，左闭右开 [ ,)。
                int k = start;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[k++] = array[start1] <= array[start2] ? array[start1++] : array[start2++];
                }
                while (start1 < end1) {
                    result[k++] = array[start1++];
                }
                while (start2 < end2) {
                    result[k++] = array[start2++];
                }
            }
            //每一轮 外循环结束之后，将原数组和结果数组替换一下，因为下一轮的排序数组是从 array 中读取的
            int[] tmp = array;
            array = result;
            result = tmp;
        }
        return array;
    }
}
