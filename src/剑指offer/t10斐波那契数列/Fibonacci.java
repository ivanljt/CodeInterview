package 剑指offer.t10斐波那契数列;

/**
 * 求斐波那契的第 n 项
 */
class Fibonacci {
    /**
     * 递归的解法
     */
    public int FibonacciRecursiveSolution(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return FibonacciRecursiveSolution(n - 1) + FibonacciRecursiveSolution(n - 2);
    }

    /**
     * 迭代解法
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(1)
     */
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = f1 + f2;
        int i = 3;
        while (i <= n) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            i++;
        }
        return f3;
    }
}
