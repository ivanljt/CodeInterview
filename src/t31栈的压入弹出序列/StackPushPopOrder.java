package t31栈的压入弹出序列;

import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列
 * 对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
class StackPushPopOrder {

    /**
     * 思路：申请一个辅助栈。遍历入栈序列，逐个入栈，每一轮都循环检查栈顶元素是否与出栈元素相等，如果相等，出栈，index++
     * */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, popIndex = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[popIndex]){
                popIndex++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
