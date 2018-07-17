package t38StringPermutation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
class StringPermutation {
    /**
     * 思路：按照我们人工手写全排列的方法，会先固定一个的字符，然后对剩余字符进行全排列，
     * 然后换一个字符固定，对其后面的剩余字符进行全排列（在一个循环中实现，后面的字符依次与「第一个字符」进行交换）。而每次对剩余字符进行全排列时，
     * 仍旧按照固定一个字符，全排列剩余字符的方法。因此这就是一个子问题，
     * 而结束的条件就是，只剩一个字符的时候。
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        Permutation(str.toCharArray(), 0, result);
        Collections.sort(result);
        return result;
    }

    void Permutation(char[] ary, int i, ArrayList<String> result) {
        if (i == ary.length - 1) {//到达尾部了
            String str = new String(ary);
            if (!result.contains(str)) {
                result.add(str);
            }
        } else {
            for (int j = i; j < ary.length; j++) {//先跟「第一个字符」进行交换。然后找出这种可能
                System.out.println("before Swap " + Arrays.toString(ary));
                swap(ary, i, j);//与指定的字符交换
                System.out.println("before Permutation " + Arrays.toString(ary));
                Permutation(ary, i + 1, result);//求固定字符后的排列。注意，这里传递的是 i + 1.不是 j + 1
                System.out.println("after Permutation " + Arrays.toString(ary));
                swap(ary, i, j);
                System.out.println("after Swap " + Arrays.toString(ary));
            }
        }
    }

    void swap(char[] ary, int i, int j) {
        char tmp = ary[i];
        ary[i] = ary[j];
        ary[j] = tmp;
    }

    public static void main(String[] args) {
        new StringPermutation().Permutation("abcd");
    }

}
