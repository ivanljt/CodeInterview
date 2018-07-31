package t多线程交替打印奇偶数;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 已知数组 A 内容为1、2、3、4...52，数组 B 内容为 26 个英文字母，
 * 使用两个线程分别输入两个数组，然后使程序运行打印内容为 12a34b56c78e... 的规律，
 * 请给出代码实现？
 */
public class MultiThreadPrint2 {

    public static void main(String[] args) {

    }
}

//自旋锁解法,数值以及自旋锁都从外部注入
class Solution1 {
    public static void main(String[] args) {
        AtomicBoolean isNum = new AtomicBoolean(true);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        new PrintNums(nums, isNum).start();
        new PrintChars(chars, isNum).start();
    }

    private static class PrintNums extends Thread {
        int[] mNums;
        private AtomicBoolean mIsNum;

        public PrintNums(int[] nums, AtomicBoolean isNum) {
            mNums = nums;
            mIsNum = isNum;
        }

        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < mNums.length; i++) {
                while (!mIsNum.get()) {//不是打印数字
                    //使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。
                    //cpu会从众多的可执行态里选择，即当前线程有可能再次执行到。
                    Thread.yield();
                }
                System.out.print(mNums[i]);
                count++;
                if (count == 2) {
                    mIsNum.set(false);
                }
            }
            mIsNum.set(false);

        }
    }

    private static class PrintChars extends Thread {
        private char[] mChars;
        private AtomicBoolean mIsNum;

        public PrintChars(char[] chars, AtomicBoolean isNum) {
            mChars = chars;
            mIsNum = isNum;
        }

        public void run() {
            int count = 0;
            for (int i = 0; i < mChars.length; i++) {
                while (mIsNum.get()) {//打印数字
                    Thread.yield();
                }
                System.out.print(mChars[i]);
                count++;
                if (count == 1) {
                    mIsNum.set(true);
                    count = 0;
                }
            }
            mIsNum.set(true);
        }
    }
}