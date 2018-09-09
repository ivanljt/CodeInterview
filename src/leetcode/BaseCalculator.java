package leetcode;

import java.util.Stack;

/**
 * 224.
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 *
 * Example 1:
 * <p>
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 * <p>
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * <p>
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
class BaseCalculator {

    /**
     * 因为输入是合法的，所以括号是成对的，数字的分隔也是正确的。
     * 遍历 输入的字符串中的每一个字符。
     *
     * 有五个需要注意的地方
     * 1. 数字 ： 说明它是当前数字的一位
     * 2. '+' ： 说明当前数字已经结束，可以加上之前的结果，然后将数字归零，以便开启下一个数字
     * 3. '-' ： 同上
     * 4. '(' ： 将之前的结果以及符号 入栈，将结果设为0，计算括号内的新结果
     * 5. ')' ： 从栈中弹出两个数，第一个是数字，第二个是 括号之前的临时结果，将它们加起来
     * 6. 空格，或者是其他输入，直接忽略
     *
     * * 时间复杂度 O(N)
     * * 空间复杂度 O(N)  比如 ((((((1+5))))))
     * */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;//符号用整型，方便入栈，以及计算
        int number = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';//数值处理。
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;//后面新数字的符号
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;//后面新数字的符号
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                //「重置」。计算括号内的数字
                sign = 1;
                result = 0;
            } else if (c == ')') {//括号内的数字计算完了
                result += sign * number;
                number = 0;

                result *= stack.pop();//先出栈的是 符号
                result += stack.pop();//加上之前的值
            }
        }
        if (number != 0) result += sign * number;
        return result;
    }
}
