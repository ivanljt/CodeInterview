package t如何仅用递归函数和栈操作逆序一个栈;

import java.util.Stack;

/**
 * 一个栈一次压入了1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1.
 * 将这个栈转置后，从栈顶到栈底为1、2、3、4、5，
 * 也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 */
class ReverseStack {
    /**
     * 每一轮获取**栈底元素**，用局部变量把它存起来，一直到栈底为空。
     * 最深的那层递归中，临时变量是栈底元素。
     *
     * 每一轮中，先获取并移除栈底元素，使用局部变量保存该值
     * 进行下一轮递归。
     * 将保存的值 重新入栈。
     * 递归终止条件：栈为空
     * */
    void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int tmp = getAndRemoveBottomElement(stack);//获取并移除栈底元素
        reverse(stack);//递归
        stack.push(tmp);//
    }

    /**
     * 从一个「非空」栈中，以递归的方式获取并移除栈底元素。
     * <p>
     * 终止条件：到达栈底，直接将栈底元素返回去
     * 每一轮递归中，如果不是到栈底，则先进行下一轮的递归，然后将本次弹出的数字压回栈中，以保存相对顺序。
     */
    int getAndRemoveBottomElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {//已经到达了栈底,直接将数字返回去
            return result;
        } else {//还没到栈底。继续递归
            int tmp = getAndRemoveBottomElement(stack);
            stack.push(result);//将这次出栈的的数字重新压栈
            return tmp;
        }
    }

    public static void main(String[] args) {
        ReverseStack reverseStack = new ReverseStack();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack.toString());
        reverseStack.reverse(stack);
        System.out.println(stack.toString());
    }
}
