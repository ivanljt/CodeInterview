package t查找与搜索;

import java.util.Arrays;

import t八大排序.DataFactory;

/**
 * 二分查找
 */
class BinarySearch {
    /**
     * @param ary    输入的有序数组
     * @param target 要查找的目标数字
     */
    public int binary(int[] ary, int target) {
        int left = 0;
        int right = ary.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (ary[mid] == target) {
                return mid;
            } else if (ary[mid] > target) {
                right = mid - 1;//调整右边界
            } else {
                left = mid + 1;//调整左边界
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ary = DataFactory.getRandomAry(15, 16);
        Arrays.sort(ary);
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binary(ary, 10);
        System.out.println(Arrays.toString(ary));
        System.out.println("target number index " + index);
    }
}