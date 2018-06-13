package t八大排序;

import java.util.Arrays;

import javax.xml.crypto.Data;

class BubbleSort {
    public static void main(String[] args) {
        int[] ary = DataFactory.getRandomAry(10);
        System.out.println("beforeSort: " + Arrays.toString(ary));
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSortOptimization(ary);
        System.out.println("afterSort: " + Arrays.toString(ary));
        Arrays.sort(ary);//官方排序
    }

    /**
     * * 时间复杂度 O(N^2)
     * * 空间复杂度 O(1)
     */
    int[] bubbleSort(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = 1; j < ary.length - i; j++) {
                if (ary[j] < ary[j - 1]) {//大数往后面挪,每一轮确定「最后一个位置」的数字
                    int tmp = ary[j];
                    ary[j] = ary[j - 1];
                    ary[j - 1] = tmp;
                }
            }
        }
        return ary;
    }

    /**
     * 优化的点：如果某一轮结束之后没有发生交换，说明数组已经有序，不需要再做比较了。
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     */
    int[] bubbleSortOptimization(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            boolean hasExchange = false;
            for (int j = 1; j < ary.length - i; j++) {
                if (ary[j] < ary[j - 1]) {//大数往后面挪,每一轮确定「最后一个位置」的数字
                    int tmp = ary[j];
                    ary[j] = ary[j - 1];
                    ary[j - 1] = tmp;
                    hasExchange = true;
                }
            }
            if (!hasExchange) {//没有发生交换，说明已经有序
                return ary;
            }
        }
        return ary;
    }
}
