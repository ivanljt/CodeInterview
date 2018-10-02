package leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class T67AddBinary {
    /**
     * 思路，从个位数开始算起。
     * 从后往前遍历，只要 >= 0 ，都应该计算进当前位到 sum 中。
     * 因为是二进制，当前位要么是 1 要么是 0。将 sum % 2 即可
     * 然后进位，仅当 sum >= 2 的时候，carry = 1. 判断条件为 sum/2;
     * 遍历结束之后，可能还有一个进位，这时需要添加进位
     * 最后，由于 append 是在后面追加，也就是说我们用 StringBuilder 保存的结果是跟真正的结果相反的。所以还要先调用 reverse 方法再返回。
     * * 时间复杂度 O(max(a.len,b.len))
     * * 空间复杂度 O(max(a.len,b.len))
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;//进位
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

class History {
    /**
     * 遍历顺序弄错了。从个位开始计算的话，应该是 从后往前。
     */
    public String addBinary(String a, String b) {
        int carry = 0;
        int aLen = a.length();
        int bLen = b.length();
        int[] result = new int[aLen > bLen ? aLen + 1 : bLen + 1];//用数组保存结果不是一个好的选择，应该用 StringBuilder.append
        int i;
        //循环的写法不好，总共有三个循环，并且三个循环的循环体做的事情相似
        for (i = 0; i < aLen && i < bLen; i++) {
            int s = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;//结果可能是 0 1 2 3
            if (s >= 2) {
                carry = 1;
                if (s > 2) {
                    result[i] = 1;
                } else {
                    result[i] = 0;
                }
            } else {
                carry = 0;
                result[i] = s;
            }
        }
        while (i < aLen - 1) {
            int s = a.charAt(i) - '0' + carry;//结果可能是 0 1 2
            if (s < 2) {
                result[i] = s;
                carry = 0;
            } else {
                result[i] = 0;
                carry = 1;
            }
            i++;
        }
        while (i < bLen - 1) {
            int s = b.charAt(i) - '0' + carry;//结果可能是 0 1 2
            if (s < 2) {
                result[i] = s;
                carry = 0;
            } else {
                result[i] = 0;
                carry = 1;
            }
            i++;
        }

        int offset = result.length - 1;
        if (carry == 1) {
            result[result.length - 1] = 1;
            offset++;
        }
        int x = 0;
        int y = offset - 1;
        while (x < y) {
            int c = result[x];
            result[x] = y;
            result[y] = c;
            x++;
            y--;
        }

        return new String(result, 0, offset);
    }
}