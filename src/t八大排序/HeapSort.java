package t八大排序;

import java.util.Arrays;

/**
 * 思路：首先建立一个大顶堆或者小顶堆，每一轮中将堆顶的元素与当前最后的一个叶子节点交换，然后调整堆，保持堆序性。
 * 分三步走：
 * 1. 建堆。从第一个非叶子节点开始（因为叶子节点可以视为一棵满足堆序性的树）
 * 2. 排序，每一轮的排序过程中都需要堆化
 * <p>
 * <p>
 * 如何建堆？假设我们要建立的是一个大顶堆，
 * 大顶堆的特性：任意一个节点都大于它的左右子节点（如果有的话）
 * 假设我们使用数组来存储堆节点的话
 * 父节点的下标是 0，那么左右叶子节点的下标分别为 1，2；
 * 父节点的下标是 1，那么左右叶子节点的下标分别为 3，4；
 * 父节点的下标是 2，那么左右叶子节点的下标分别为 3，4；
 * 推广（因为堆是一种完全二叉树）：当前节点下标为 i，那么 左子节点的下标为 2i+1 右子节点的下标为 2i+2
 * <p>
 * 确定了父子节点下标关系之后，我们的问题就变成了如何对堆进行调整，维护堆序性
 * 上浮和下潜。
 */
class HeapSort {
    public static void main(String[] args) {
        int[] ary = DataFactory.getRandomAry(10);
        System.out.println(Arrays.toString(ary));
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(ary, ary.length);
        System.out.println(Arrays.toString(ary));
    }

    public int[] heapSort(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) {
            return A;
        }
        //建堆
        int beginIndex = n >> 1;//从第一个非叶子节点开始
        for (int i = beginIndex; i >= 0; i--) {//自下而上建立堆
            maxHeapify(A, i, n);
        }
        //排序
        for (int i = n - 1; i >= 0; i--) {//
            swap(A, 0, i);//堆顶元素跟堆尾元素交换
            maxHeapify(A, 0, i);//
        }
        return A;
    }

    void maxHeapify(int[] ary, int index, int n) {
        int lIndex = index * 2 + 1;
        int rIndex = lIndex + 1;

        if (lIndex >= n) {//检查数组越界
            return;
        }
        int maxIndex = lIndex;//
        //需要避免数组越界
        if (rIndex < n) {
            maxIndex = ary[lIndex] < ary[rIndex] ? rIndex : lIndex;
        }
        if (ary[index] < ary[maxIndex]) {//下沉
            swap(ary, index, maxIndex);
            maxHeapify(ary, maxIndex, n);//继续判断换下后的父节点是否符合堆的特性。
        }
    }

    void swap(int[] ary, int l, int r) {
        int tmp = ary[l];
        ary[l] = ary[r];
        ary[r] = tmp;
    }
}
