/**
 * 求出最大公约数。
 * 几个自然数公有的约数，叫做这几个数的公约数；其中最大的一个，叫做这几个数的最大公约数。
 * <p>
 * 例如：12，16的公约数有1，2，4，其中最大的一个是4，4是12与16的最大公约数
 */
class MaxCommonFactor {
    /**
     * 暴力穷举法。
     * 取两个数中的较小者，然后用这个数开始往下 减，
     * 如果这个数能够同时被 m,n 整除，说明它是最大公约数。
     **/
    static int maxNum(int m, int n) {
        int tmp = m > n ? n : m;
        for (int i = tmp; i > 0; i--) {
            if (m % i == 0 && n % i == 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 辗转相除法。迭代解法
     * 设有两个整数 a 和 b
     * 1. a % b 得余数 c
     * 2. 若 c=0，则 b 即为两数的最大公约数
     * 3. 若 c≠0，则令 a=b，b=c，再执行1
     * <p>
     */
    static int maxNumIterative(int m, int n) {
        // 取模运算，先不需要取大数。如果前面的数小于后面的数，
        // 比如 m = 9 n = 27。
        //第一次循环为
        //c = 9 % 27 = 9
        //m = 27
        //n = 9
        //也就是说第一个循环会进行「矫正」
        int c;
        while (n != 0) {
            c = m % n;
            m = n;
            n = c;
        }
        return m;
    }

    /**
     * 辗转相除法。递归实现
     */
    static int maxNumRecursive(int m, int n) {
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        if (m % n == 0) {
            return n;
        }
        return maxNumRecursive(n, m % n);
    }


    public static void main(String[] args) {
        int fac = maxNumIterative(9, 27);
        System.out.println(fac);
    }
}
