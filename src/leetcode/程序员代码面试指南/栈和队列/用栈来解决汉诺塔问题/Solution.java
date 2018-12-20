package leetcode.程序员代码面试指南.栈和队列.用栈来解决汉诺塔问题;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        func_C(2, 'a', 'b', 'c');
    }

    private static void func_R(int floor, char a, char b, char c) {
        if (floor == 2) {
            System.out.println(a + "->" + c);
            return;
        }
        func_R(floor - 1, a, c, b);
        func_R(1, a, b, c);
        func_R(floor - 1, b, a, c);
    }

    static class State {
        int floor;
        char a;
        char b;
        char c;

        public State(int floor, char a, char b, char c) {
            this.floor = floor;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


    private static void func_C(int floor, char a, char b, char c) {
        Stack<State> stack = new Stack<>();
        State cur = new State(floor, a, b, c);
        while (cur.floor != 0 || !stack.isEmpty()) {
            while (cur.floor != 0) {
                stack.push(cur);
                if (cur.floor == 1) {
                    System.out.println(cur.a + "->" + cur.c);
                }
                cur = new State(cur.floor - 1, cur.a, cur.c, cur.b);
            }

            cur = stack.pop();
            if (cur.floor != 1) {
                System.out.println(cur.a + "->" + cur.c);
            }
            cur = new State(cur.floor - 1, cur.b, cur.a, cur.c);
        }
    }
}
