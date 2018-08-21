package 剑指offer.t21调整数组顺序使奇数位于偶数前;

import java.util.Arrays;

import t八大排序.DataFactory;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
class SortOddAndEven {
//要求有序，而直接用双指针无法保证有序


    /**
     * 思路：借助一个长度为 N 的数组，
     * 1. 先统计奇数的个数（统计的同时也可以将奇数存储到辅助数组）
     * 2. 遍历数组，偶数存储到后面
     * 3. 将辅助数组的内容复制打破原数组
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(N)
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] copy = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {//注意，不要 %1，%1 永远都为0。 奇数 &1 结果为1
                copy[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                copy[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = copy[i];
        }
    }

    /**
     * 偶数按顺序缓存到temp数组中，奇数按顺序放到原数组前面。
     * 最后将temp数组中的偶数依次按序放在原数组后面
     * 减少复制的元素数
     */
    public void reOrderArray2(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] copy = new int[array.length];
        int evenIndex = 0;
        int oddIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                copy[evenIndex] = array[i];//偶数存储在辅助数组 开头
                evenIndex++;//
            } else {//奇数
                // 将奇数依次放在原数组前面
                if (oddIndex < i)
                    array[oddIndex] = array[i];//奇数存储在原数组 开头
                oddIndex++;
            }
        }
        for (int i = oddIndex; i < array.length; i++) {
            array[i] = copy[i - oddIndex];
        }
    }

    public static void main(String[] args) {
        int[] ary = DataFactory.getRandomAry(10);
        System.out.println(Arrays.toString(ary));
        new SortOddAndEven().reOrderArray2(ary);
        System.out.println(Arrays.toString(ary));
    }
}
