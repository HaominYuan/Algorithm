package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    static class MySolution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> operator = new Stack<>();
            for (String token : tokens) {
                switch (token) {
                    case "+": {
                        int number1 = operator.pop();
                        int number2 = operator.pop();
                        operator.push(number1 + number2);
                        break;
                    }
                    case "-": {
                        int number1 = operator.pop();
                        int number2 = operator.pop();
                        operator.push(number1 - number2);
                        break;
                    }
                    case "*": {
                        int number1 = operator.pop();
                        int number2 = operator.pop();
                        operator.push(number1 * number2);
                        break;
                    }
                    case "/": {
                        int number1 = operator.pop();
                        int number2 = operator.pop();
                        operator.push(number1 / number2);
                        break;
                    }
                    default:
                        operator.push(Integer.parseInt(token));
                        break;
                }
            }
            return operator.pop();
        }
    }

    static class Solution {
        private int N = -1;

        public int evalRPN(String[] tokens) {
            if (N == -1)
                N = tokens.length - 1;
            String s = tokens[N--];
            char c = s.charAt(0);
            // 判断是否是加减乘除
            if ("+-*/".indexOf(c) != -1) {
                int a = evalRPN(tokens);
                int b = evalRPN(tokens);
                switch (c) {
                    case '+':
                        return a + b;
                    case '-':
                        return b - a;
                    case '*':
                        return a * b;
                    case '/':
                        return b / a;
                    default:
                        break;
                }
            }

            // 返回数字
            return Integer.parseInt(s);
        }
    }

}
