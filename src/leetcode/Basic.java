package leetcode;

import java.util.Stack;

public class Basic {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("2 - 1 + 2"));

    }

    static class Solution {
        public int calculate(String s) {
            Stack<Character> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            boolean last = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    continue;
                }
                if ('0' <= s.charAt(i) && s.charAt(i) <= s.charAt(i)) {
                    if (last) {
                        Integer temp = stack2.pop();
                        temp = temp * 10 + s.charAt(i) - '0';
                        stack2.push(temp);
                    } else {
                        stack2.push(s.charAt(i) - '0');
                    }
                    last = true;
                } else {
                    last = false;
                    if (s.charAt(i) == '(') {
                        stack1.push(s.charAt(i));
                    } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                        if (!stack1.isEmpty()) {
                            while (true) {
                                char temp = stack1.peek();
                                if (temp == '+') {
                                    stack2.push(stack2.pop() + stack2.pop());
                                    stack1.pop();
                                } else if (temp == '-') {
                                    stack2.push(-stack2.pop() + stack2.pop());
                                    stack1.pop();
                                } else {
                                    break;
                                }

                                if (stack1.isEmpty()) {
                                    break;
                                }
                            }
                        }
                        stack1.push(s.charAt(i));

                    } else if (s.charAt(i) == ')') {
                        char temp = stack1.pop();
                        while (temp != '(') {
                            if (temp == '+') {
                                stack2.push(stack2.pop() + stack2.pop());
                            } else {
                                stack2.push(-stack2.pop() + stack2.pop());
                            }
                            temp = stack1.pop();
                        }
                    }
                }
            }
            while (!stack1.isEmpty()) {
                char temp = stack1.pop();
                if (temp == '+') {
                    stack2.push(stack2.pop() + stack2.pop());
                } else {
                    stack2.push(-stack2.pop() + stack2.pop());
                }
            }
            return stack2.pop();
        }
    }
}
