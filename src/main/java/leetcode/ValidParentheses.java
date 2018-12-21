package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String instance = "()";
        System.out.println(Solution.isValid(instance));
        instance = "()[]{}";
        System.out.println(Solution.isValid(instance));
        instance = "(]";
        System.out.println(Solution.isValid(instance));
        instance = "([)]";
        System.out.println(Solution.isValid(instance));
        instance = "{[]}";
        System.out.println(Solution.isValid(instance));
        instance = "[])";
        System.out.println(Solution.isValid(instance));
    }

    static class Solution {
        static boolean isValid(String s) {
            if (s.length() == 0) {
                return true;
            }
            Stack<Character> characters = new Stack<>();
            characters.add(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    characters.push(s.charAt(i));
                } else {
                    try {
                        char temp = characters.peek();
                        if (temp == '(' && s.charAt(i) == ')' || temp == '[' && s.charAt(i) == ']' || temp == '{' && s.charAt(i) == '}') {
                            characters.pop();
                        } else {
                            return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
            return characters.isEmpty();
        }
    }
}
