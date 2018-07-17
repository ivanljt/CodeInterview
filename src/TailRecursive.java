
/**
 * 尾递归。
 * 尾递归的实现，往往需要改写递归函数，确保最后一步只调用自身。做到这一点的方法，
 * 就是把所有用到的内部变量改写成函数的参数。比如上面的例子，阶乘函数 factorial 需要用到一个中间变量 total ，
 * 那就把这个中间变量改写成函数的参数。
 * 这样做的缺点就是不太直观，第一眼很难看出来，为什么计算5的阶乘，需要传入两个参数5和1？
 * 两个方法可以解决这个问题。
 * 方法一，是在尾递归函数之外，再提供一个正常形式的函数。
 * 方法二，如果使用的语言支持默认的参数值的话，将默认值设置为1
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
        System.out.println(tailRecursive.factorial(30));
    }
}
