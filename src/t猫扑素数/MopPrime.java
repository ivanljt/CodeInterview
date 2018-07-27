package t猫扑素数;

/**
 * 形如以 2 开头， 之后跟任意多个 3 的十进制整数如果是个素数， 则它是猫扑素数。
 * 如 2、 23、 233、2333、23333 都是猫扑素数， 而 233333 则不是，
 * 它可以分解为 353 x 661。
 * 设计一个函数，输入一个 int 类型的数，判断它是否是猫扑素数
 */
class MopPrime {

    public static void main(String[] args) {
        MopPrime mopPrime = new MopPrime();
        System.out.println(mopPrime.isMopPrime(23333));
        System.out.println(mopPrime.isMopPrime(233333));
    }

    boolean isMopPrime(int num) {
        if (num <= 1) {//素数（也称质数），定义为 在大于1的自然数中，除了1和它本身以外不再有其他因数。
            return false;
        }
        return isMop(num) && isPrime(num);
    }

    /**
     * 用n除以 2~sqrt(n) ,有一个能除尽就不是素数，否则是素数。
     * 因为m的一个因子如果大于根号m，那这个数必定对应的还有一个比根号m小的因子。
     * * 时间复杂度 O(sqrt(n))
     * * 空间复杂度 O(1)
     */
    private boolean isPrime(int num) {
        if (num == 2) {//如果 num 为 2 需要特殊处理
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {//是否能够被整除
                return false;
            }
        }
        return true;
    }

    /**
     * 第一个是2，后面任意多个 3
     * /10 去掉个位
     * %10 得到个位的值
     */
    private boolean isMop(int num) {
        //从右往左扫。如果该数字大于 10，那么 num%10 要等于 3，否则，为 false
        while (num / 10 > 0) {
            if ((num % 10) != 3) {
                return false;
            }
            num /= 10;
        }
        return num == 2;
    }


    /**
     * 第一个是2，后面任意多个 3
     * 借助字符串
     */
    private boolean isMopByStr(int num) {
        //从右往左扫。
        char[] chars = String.valueOf(num).toCharArray();
        if (chars[0] != '2') {
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != '3') {
                return false;
            }
        }
        return true;
    }
}
