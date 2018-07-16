
/**
 * 尾递归。
 * 在结尾调用自身。
 */
public class TailRecursive {
    /**
     * 尾递归计算阶乘
     */

    long factorial(long n) {
        return factorial(n, 1);
    }

    long factorial(long n, long total) {
        if (n == 1) {
            return total;
        }
        return factorial(n - 1, n * total);//方法的结尾调用自身
    }

    long nonTailRecursive(long n) {
        if (n == 1) {
            return 1;
        }
        return n * nonTailRecursive(n - 1);//非尾递归
    }

    public static void main(String[] args) {
        TailRecursive tailRecursive = new TailRecursive();
        System.out.println(tailRecursive.factorial(50));
    }
}
