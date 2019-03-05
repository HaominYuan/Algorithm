package leetcode;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> assistStack;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (assistStack.isEmpty()) {
            assistStack.push(x);
        } else {
            assistStack.push(Math.min(x, assistStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        assistStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return assistStack.peek();
    }
}
