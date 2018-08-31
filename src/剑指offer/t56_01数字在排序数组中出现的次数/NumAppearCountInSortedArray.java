package 剑指offer.t56_01数字在排序数组中出现的次数;

import java.util.Arrays;

import t八大排序.DataFactory;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
class NumAppearCountInSortedArray {

    /**
     * 思路:排序数组。遍历，比较。一直到数组结束或者是当前元素大于目标值
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0
                || k < array[0] || k > array[array.length - 1]) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            } else if (array[i] > k) {
                break;
            }
        }
        return count;
    }
}

class Sol {
    /**
     * [1,3,3,3,3,4,5],6
     */
    public static void main(String[] args) {
        Sol sol = new Sol();
        int[] a = DataFactory.getRandomAry(10, 10);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(sol.getStartIndex(a, 5));
        System.out.println(sol.getEndIndex(a, 5));
        System.out.println(sol.GetNumberOfK(a, 10));

        int[] ary = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(sol.GetNumberOfK(ary, 6));
    }

    /**
     * 二分找到左右边界。出现次数为 end-start+1
     */
    public int GetNumberOfK(int[] array, int k) {
        int index1 = getStartIndex(array, k);
        int index2 = getEndIndex(array, k);
        if (index1 == -1 || index2 == -1) {
            return 0;
        }
        return index2 - index1 + 1;
    }

    int getStartIndex(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                if (mid == 0 || (mid - 1 >= 0 && array[mid - 1] != k)) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    int getEndIndex(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            if (array[mid] < k) {
                start = mid + 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                if (mid == array.length - 1 || (mid + 1 < array.length && array[mid + 1] != k)) {
                    return mid;
                } else {//继续往右边找
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 二分的递归写法
     */
    int getFirstIndex(int array[], int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (array[mid] == k) {
            if (mid == 0
                    || (mid > 0 && array[mid - 1] != k)) {//1 已经到达数组的第一个位置；2 前面的那个数！= k
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (array[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getFirstIndex(array, start, end, k);

    }

    int getLastIndex(int array[], int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (array[mid] == k) {
            if (mid == array.length - 1
                    || (mid < array.length - 1 && array[mid + 1] != k)) {//1 已经到达数组的最后一个位置；2 后面的那个数！= k
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (array[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getLastIndex(array, start, end, k);
    }

}

