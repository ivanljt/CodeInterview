package t15二进制中1的个数;

class NumOf1 {

    //存在一个问题就是  >> 右移 高位默认补上 符号位，>>> 无符号位移可以解决这个问题，高位补 0
    // 这样可能会导致死循环。
    public int NumberOf1Impl1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public int NumberOf1(int n) {
        //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
        //按位与，循环右移，一直到32位都搞定。
        //或者，让一个数从 1 —>2—>4 分别跟 n 进行与 操作
        int count = 0;
        int flag = 1;
        while (flag != 0) {//在最高位左移之后，值为0
            //System.out.println(Integer.toBinaryString(n & flag));
            if ((n & flag) != 0) {// 注意是不等于 0。因为是按位与，假如双方的 都为8二进制表示为（100）那么相与的结果就是 （100）。而不是1
                count++;
            }
            flag = (flag << 1);
        }
        return count;
    }

    /**
     * 最优解。
     * 如果不等于0，则至少有一个位为1。
     * 一个数与它自身-1 相与，得到的是最后一位为
     */
    public int NumberOf1Optimation(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }


    public static void main(String[] args) {
        NumOf1 numOf1 = new NumOf1();
        assert numOf1.NumberOf1Optimation(10) == 2;
    }
}
