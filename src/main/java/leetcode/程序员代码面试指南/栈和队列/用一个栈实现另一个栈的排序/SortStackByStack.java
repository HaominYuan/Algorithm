package leetcode.程序员代码面试指南.栈和队列.用一个栈实现另一个栈的排序;

import java.util.Stack;

public class SortStackByStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        sortStackByStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    private static void sortStackByStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Stack<Integer> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            int count = 0;
            while (!newStack.isEmpty() && newStack.peek() < temp) {
                stack.push(newStack.pop());
                count = count + 1;
            }
            newStack.push(temp);
        }

        while (!newStack.isEmpty()) {
            stack.push(newStack.pop());
        }
    }

}
