package t16数值的整数次方;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
class Power {

    public double Power(double base, int exponent) {
        //exponent 可能 < 0
        if (exponent == 0) {
            return 1;
        }
        int exp = Math.abs(exponent);
        double result = 1.0;//result 应该声明为 double ，否则有些 case 无法覆盖。比如 0.25 -3
        while (exp > 0) {
            result *= base;
            exp--;
        }

        return exponent > 0 ? result : 1.0 / result;
    }

    //奇数次方 result = base^(exp) /2 * base^(exp) /2 * base
    //偶数次方 result = base^exp /2 * base^exp /2
    public double Power2(double base, int exponent) {
        //正负的情况，最顶层考虑就够了,后面的递归调用中，exponent 均为正
        int exp = Math.abs(exponent);

        if (exp == 0) {
            return 1.0;
        }
        double result = 1.0;
        result = Power2(base, exp >> 1);//递归，结果存储在 result 中，然后 result * result，避免了重复相同的递归计算
        result *= result;//平方
        //注意运算符的优先级
        if ((exp & 1) != 0) {//如果指数是奇数，需要再乘以 base。
            result *= base;
        }
        return exponent > 0 ? result : 1 / result;//指数的正负判断。仅在第一层调用是 exponent 才有可能为 负数
    }

}
