package leetcode;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    int min;
    int time;



    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
        int time = 0;
    }

    public void push(int x) {
        stack.push(x);
        if (x < min) {
            min = x;
            time = 1;
        }
    }

    public void pop() {
        int tmp = stack.pop();
        if (tmp == min) {
            time = time - 1;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
