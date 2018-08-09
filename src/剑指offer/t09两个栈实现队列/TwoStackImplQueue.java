package 剑指offer.t09两个栈实现队列;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 **/

//队列—>先进先出
//栈—>后进先出
//入队列都往一个栈中添加
//出队列先检查 stack2 是否为空，如果为空，
// 将 stack1 中所有的元素都添加到 stack2 中。完成之后仍然需要检查stack2是否为空，如果为空，则抛出异常

//类似的题目：双队列实现栈
class TwoStackImplQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("stack is empty，can't pop");
        }
        return stack2.pop();
    }
}
