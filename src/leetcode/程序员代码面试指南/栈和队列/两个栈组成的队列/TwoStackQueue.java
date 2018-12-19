package leetcode.程序员代码面试指南.栈和队列.两个栈组成的队列;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int newNum) {
        stackPush.push(newNum);
    }

    public int poll() {
        func();
        return stackPop.pop();
    }

    public int peek() {
        func();
        return stackPop.peek();
    }

    private void func() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Your queue is empty.");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
}
