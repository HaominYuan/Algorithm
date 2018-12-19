package leetcode.程序员代码面试指南.栈和队列.用递和栈操作实现栈的逆序;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        new Solution().reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static class Solution {
        public void reverse(Stack<Integer> stack) {
            if (stack.isEmpty()) {
                return;
            }

            int last = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(last);
        }

        private int getAndRemoveLastElement(Stack<Integer> stack) {
            int value = stack.pop();
            if (stack.isEmpty()) {
                return value;
            } else {
                int last = getAndRemoveLastElement(stack);
                stack.push(value);
                return last;
            }
        }
    }




}
