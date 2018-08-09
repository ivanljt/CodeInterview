package 剑指offer.t30包含min的栈;

import java.util.Stack;

class StackMin {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 维护一个「最小值」栈。当插入新元素的时候，与「最小值栈」栈顶元素 min 进行比较，如果 min < 重新加入栈
     * pop 的时候同步弹出即可。
     * 查看/弹出元素之前都需要先将元素弹出来
     */
    public void push(int node) {
        stack.push(node);
        //注意这里的逻辑，如果栈为空，直接将 node push 进去
        //如果栈不为空，并且节点大于栈顶节点，也是直接把节点入 minStack
        if (minStack.isEmpty() || minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack isEmpty");
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack isEmpty");
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("stack isEmpty");
        }
        return minStack.peek();
    }
}

