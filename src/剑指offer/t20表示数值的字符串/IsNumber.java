package 剑指offer.t20表示数值的字符串;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
class IsNumber {
    /**
     * 思路：一开始考虑的是 特殊字符不能出现在指定位置。并且是跟前后的内容有依赖。
     * 没有想到 使用遍历的方式，然后通过 标志位（或者是用数字也行）。
     * <p>
     * 设置三个标志符分别记录“+/-”、“e/E”和“.”是否出现过。
     * <p>
     * 对于“+/-”： 它们第一次出现的话应该出现在字符串的第一个位置，如果它第一次出现在不是字符串首位，而且它的前面也不是“e/E”，那就不符合规则；
     * 如果是第二次出现，那么它就应该出现在“e/E”的后面，如果“+/-”的前面不是“e/E”，那也不符合规则。
     * 第一次出现，后面必须是数字或者是 . 第二次出现，后面必须是数字
     * <p>
     * 对于“e/E”： 如果它的后面不接任何数字，就不符合规则；如果出现多个“e/E”也不符合规则。
     * <p>
     * 对于“.”： 出现多个“.”是不符合规则的。还有“e/E”的字符串出现“.”也是不符合规则的。 同时，要保证其他字符均为 0-9 之间的数字。
     *
     * 11E+ 是符合要求的。也就是
     **/
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        boolean hasSign = false;
        boolean hasE = false;
        boolean hasDot = false;
        char c;
        for (int i = 0; i < str.length; i++) {
            c = str[i];
            if (c == 'e' || c == 'E') {
                if (hasE || i == str.length - 1) {//最多只能出现一次，并且后面必须是数字或者或者符号
                    return false;
                }
                hasE = true;
            } else if (c == '+' || c == '-') {//符号要么在第一位，要么在 e 后面
                if (!hasSign && i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {//第一次出现。不在第一位，并且前面不是 E
                    return false;
                }
                if (hasSign && str[i - 1] != 'e' && str[i - 1] != 'E') { // 第二次出现，必须在 e 后面. .
                    return false;
                }
//                //可以是 . 也可以是数字，或者没有。 因为 11E+ 是合法的
//                if (i == str.length - 1) {
//                    return false;
//                }
//                if (hasSign) {
//                    if (str[i + 1] < '0' || str[i + 1] > '9') {
//                        return false;
//                    }
//                } else {
//                    if (str[i + 1] != '.' && (str[i + 1] < '0' || str[i + 1] > '9')) {
//                        return false;
//                    }
//                }
                hasSign = true;
            } else if (c == '.') {
                if (hasDot || hasE) {// 「.」不能出现多次， 也不能出现在 E 后面
                    return false;
                }
                if (i == str.length - 1 || str[i + 1] < '0' && str[i + 1] > '9')
                    return false;//. 后面必须是数字
                hasDot = true;
            } else if (c > '9' || c < '0') {//非法字符
                return false;
            }
        }
        return true;
    }
}

class SolRecord {
    /**
     * 难点：分析出各种情况。
     * <p>
     * 思路：
     * 表示数值的字符串的 模式为 A[.[B]][E|eC] 或者是.B[E|eC]   注意 方括号表示可有可无
     * A C 部分开头可以是 + - 开头的 0~9数位串
     * B 也是0~9 的数位串，但前面不能有 - 号
     * <p>
     * 遇到 . 的时开始判断 B部分。
     * 遇到 e或者 E 开始判断 C 部分
     * <p>
     * e就相当于10，而e后面的数字，就是10的一个指数
     * <p>
     * 对特殊符号进行处理，定义三个布尔值 sign，hasDot，hasE
     * 点 只能出现一次
     * 符号后面必须是数字或者是 e
     * e 只能出现一次，并且 e 后面必须是整数（正负都可以）
     */
    boolean isNumeric(char[] str) {
        boolean sign = false;
        boolean hasDot = false;
        boolean hasE = false;
        char c;
        for (int i = 0; i < str.length; i++) {
            c = str[i];
            if (c == 'e' || c == 'E') {//e 不能出现两次并且不能是结尾
                if (hasE) return false;//e 不能出现两次
                if (i == str.length - 1) return false;//e 的后面必须由数字；e 的前面必须是数字 和后面必须数字或者 +-
                hasE = true;
            } else if (c == '.') {
                //e 之后不能出现小数点； 小数点不能出现2次以上
                if (hasDot || hasE || i == str.length - 1) return false;
                if (str[i + 1] < '0' || str[i + 1] > '9') return false;
                hasDot = true;
            } else if (c == '+' || c == '-') {
                //第一次出现 符号，并且不是在数字开头
                if (!sign && i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                //第二次出现，必须是在 e 后面
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                //第一次出现
                sign = true;
            } else if (c > '9' || c < '0') {//非法字符
                return false;
            }
        }
        return true;
    }
}