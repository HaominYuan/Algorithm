package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class PushAndPopOfTheStack {
    public static void main(String[] args) {
        System.out.println(new Solution().func("123", "321"));
    }

    static class Solution {
        boolean func(String s1, String s2) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0, j = -1; i < s2.length(); i++) {
                while (stack.isEmpty() || stack.peek() != s2.charAt(i)) {
                    if ((j = j + 1) < s1.length()) {
                        stack.push(s1.charAt(j));
                    } else {
                        return false;
                    }
                }
                stack.pop();
            }

            return true;
        }
    }

}
