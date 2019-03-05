package 程序员代码面试指南.栈和队列.设计一个有getMin功能的栈;

import java.util.Stack;

public class MinStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack2() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty() || newNum <= getMin()) {
            stackMin.push(newNum);
        } else {
            stackMin.push(getMin());
        }
        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }
}
