package t31栈的压入弹出序列;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列
 * 对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
class StackPushPopOrder {
    /**
     * 思路一：遍历出栈序列。新建一个辅助栈存储入栈序列
     * 如果当前popA 的对应的数字刚好是栈顶数字，那么直接弹；
     * 如果下一个弹出数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到下一个需要弹出的数字压入栈顶为止
     * <p>
     * 如果所有数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列
     */


    /**
     * 思路二：遍历入栈序列（因为入栈序列是确定的嘛），每一个循环中 再用 while 比较栈顶元素是不是与出栈序列的当前的元素相等，
     * 如果相等，指针指向出栈序列的下一个元素，并将辅助栈顶弹出
     * */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        //1 2 3 4 5
        //4 5 3 2 1
        //如果出的数字不在栈顶，则让它出栈
        //借助一个栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, popIndex = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && popA[popIndex] == stack.peek()) {
                popIndex++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
