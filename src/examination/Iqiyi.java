package examination;

import java.util.Arrays;
import java.util.Scanner;

class Iqiyi {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int p = 0;
        if (cin.hasNextLine()) {
            String firstLine = cin.nextLine();
            String[] s = firstLine.split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            p = Integer.parseInt(s[2]);
        }
        int[] nCount = new int[n];
        if (cin.hasNextLine()) {
            String[] s = cin.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                nCount[i] = Integer.parseInt(s[i]);
            }
        }
        while (cin.hasNextLine() && m > 0) {
            String[] s = cin.nextLine().split(" ");
            int index = Integer.parseInt(s[1]) - 1;
            if (s[0].equals("A")) {
                nCount[index]++;
            } else if (s[0].equals("B")) {
                if (nCount[index] <=0){
                    throw new IllegalArgumentException("no food left,can't eat");
                }
                nCount[index]--;
            } else {
                throw new IllegalArgumentException("should be A or B");
            }
            m--;
        }
        //排第几名
        int left = nCount[p];
        Arrays.sort(nCount);
        int rank = Arrays.binarySearch(nCount, left);
        while (rank >= 1 && nCount[rank - 1] == left) {//相同算并列
            rank--;
        }
        System.out.println(++rank);
    }

    /**
     * 小C有一张票，这张票的ID是长度为6的字符串，每个字符都是数字，他想让这个ID变成他的辛运ID，
     * 所以他就开始更改ID，每一次操作，他可以选择任意一个数字并且替换它。
     * <p>
     * 如果这个ID的前三位数字之和等于后三位数字之和，那么这个ID就是辛运的。
     * 你帮小C求一下，最少需要操作几次，能使ID变成辛运ID
     * <p>
     * 000 999 那么需要改变三个位置的数字，总共是三次。最多需要操作3次
     * 如果一致的话，那么只需 0 次
     */
    static int minOperationCount(int input) {
        String str = String.valueOf(input);
        if (str.length() != 6) {
            throw new IllegalArgumentException("input number is illegal,it should have 6 bits");
        }
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < 6; i++) {
            char c = str.charAt(i);
            if (i < 3) {
                firstSum += c - '0';
            } else {
                secondSum += c - '0';
            }
        }
        int diff = Math.abs(firstSum - secondSum);
        if (diff == 0) {
            return 0;
        } else if (diff <= 9) {
            return 1;
        } else if (diff <= 18) {
            return 2;
        } else {
            return 3;
        }
    }
}
