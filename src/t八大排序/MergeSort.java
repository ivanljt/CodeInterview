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
     * 迭代版
     * */
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for (block = 1; block < len; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while (start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
    }
}
