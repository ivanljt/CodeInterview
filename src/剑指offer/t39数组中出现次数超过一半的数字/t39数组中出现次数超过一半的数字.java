package 剑指offer.t39数组中出现次数超过一半的数字;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class t39数组中出现次数超过一半的数字 {
    /**
     * 简单粗暴的思路：直接排序,取中位数。验证合法性。
     * 也可以采用 选择排序。一直选到中间的数字。不过时间复杂度为 O(n2)
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null) {
            return 0;
        }
        Arrays.sort(array);
        return checkMoreThanHalf(array, array[array.length / 2]) ? array[array.length / 2] : 0;
    }

    private boolean checkMoreThanHalf(int[] array, int num) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }
        return count > array.length / 2;
    }
}

class Sol1 {
    /**
     * 思路：因为出现的次数超过一半 —> 比其他数字出现的次数都要多。可用一个计数器来计算这个值。
     * 遍历数组，times == 0 的时候，更新 result。否则，判断 result 与 当前元素是否相等，然后更新 times。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int times = 0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times++;
            } else if (result == array[i]) {//值相等
                times++;
            } else {//值不相等，并且times！= 0
                times--;
            }
        }
        return checkMoreThanHalf(array, result) ? result : 0;
    }

    private boolean checkMoreThanHalf(int[] array, int num) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }
        return count > array.length / 2;
    }
}


class Sol2 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;
        int index = 0;
        int result = 0;
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(array, start, end);
        }
        result = array[mid];
        return checkMoreThanHalf(array, result) ? result : 0;
    }

    //切分。左边的数都小于 i ，右边数字都大于。
    //怎么做呢？两个指针左右扫描。left 扫到大于该数字的，停止。right 扫到小于该数字的停止。然后双方
    //切分元素在该函数内部确定。
    //返回pivot 的下标

    //切分，左边 <= pivot  < 右边

    int partition(int[] a, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int pivot = a[start];
        int i = start + 1;
        int j = end;
        //切分，左边 <= pivot  < 右边
        while (i <= j) {
            while (i <= j && a[i] <= pivot) i++;
            while (i <= j && a[j] > pivot) j--;
            if (i == j) {
                i++;
            }
            if (i < j) {//这个判断是有必要的，防止 i > j的情况（可能导致数组越界）
                //交换值
                //a[i]  a[j]
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                //交换之后需要更新指针。
                i++;
                j--;
            }
        }
        a[start] = a[j];
        a[j] = pivot;
        return j;
    }

    // int partition(int[] ary, int start,int end) {
    //     int p = ary[start];
    //     int l = start+1;
    //     int r = end;
    //     while(l < r){
    //         while(ary[l] <= p){
    //             l++;
    //
    //         }
    //         while(ary[r] > p){
    //             r--;
    //         }
    //         swap(ary,l,r);
    //         if(l >= r){
    //             break;
    //         }
    //     }
    //     swap(ary,start,l);
    //     return r;
    // }
    //
    void swap(int[] ary, int l, int r) {
        int t = ary[l];
        ary[l] = ary[r];
        ary[r] = t;
    }

    private boolean checkMoreThanHalf(int[] array, int num) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }
        return count > array.length / 2;
    }
}