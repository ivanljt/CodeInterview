package t八大排序;

import java.util.Arrays;

class SelectSort {

    public static void main(String[] args) {
        int[] ary = DataFactory.getRandomAry(10);
        System.out.println("beforeSort: " + Arrays.toString(ary));
        SelectSort bubbleSort = new SelectSort();
        bubbleSort.selectSort(ary);
        System.out.println("afterSort: " + Arrays.toString(ary));
        Arrays.sort(ary);//官方排序
    }

    int[] selectSort(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            int minIndex = i;//每一轮中最小值的下标
            for (int j = i + 1; j < ary.length; j++) {
                if (ary[minIndex] > ary[j]) {
                    minIndex = j;
                }
            }

            int tmp = ary[minIndex];
            ary[minIndex] = ary[i];
            ary[i] = tmp;
        }
        return ary;
    }

}
