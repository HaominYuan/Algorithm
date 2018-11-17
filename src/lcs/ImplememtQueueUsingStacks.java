package lcs;

import java.util.Stack;

public class ImplememtQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}

class MyQueue {


    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element */
    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element */
    public int peek() {
        if (!stack2.empty()) {
            return stack2.peek();
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
