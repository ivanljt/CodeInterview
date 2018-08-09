package 剑指offer.t11旋转数组的最小数字;


/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
class MinNumberInRotateArray {
    //「若干个」也可以是0个
    //思路：有序—> 二分，
    //第一个指针指向的元素 总是<  第二个指针指向的元素
    //第一个指针总是指向前面递增的子数组。
    //第二个指针总是指向后面递增的子数组。

    //终止条件：最小元素就位于 两个数组的「交界处」——也就是当 第一个指针与第二个指针大小相差 1 的情况下。
    //特殊情况：1 1 2 3 0 1 1； 0 1 2 3 （没有翻转）
    //* 时间复杂度 O(log(N))
    //* 空间复杂度 O(log(1))
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //翻转的个数为 0 的情况
        if (array[0] < array[array.length - 1]) {
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]) {//注意有等号
            if (right - left == 1) {//到达两个递增数组的「交界处」，
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            //相等的时候无法判断属于哪一部分
            //11112  0011
            if (array[mid] == array[left] && array[mid] == array[right]) {
                int min = array[left];
                for (int i = left + 1; i <= right; i++) {
                    min = Math.min(array[i], min);
                }
                return min;
            }

            if (array[mid] >= array[left]) {//最小元素在 mid ~ right 之间
                left = mid;
            } else if (array[mid] <= array[right]) {//最小元素在 left ~ mid 之间
                right = mid;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        int[] ary = {1, 2, 2, 11, 34};
        System.out.println(binarySearch(ary, 34));
    }

    //附：二分查找
    static int binarySearch(int[] a, int target) {
        //二分查找。
        //left  right mid
        //如果 mid < target  ，说明目标在left~mid之间，right = mid
        //写错的问题：忘记对 mid + 1 -1 处理了
        int left = 0;
        int right = a.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (a[mid] < target) {
                //结果在 mid + 1 ~ right 之间。
                left = mid + 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}


