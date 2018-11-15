package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Solution.generateParenthesis(3));
    }

    static class Solution {
        static List<String> generateParenthesis(int n) {
            List<String> results = new ArrayList<>();
//            generateALl(new char[2 * n], 0, results);
//            backtrack(results, "", 0, 0, n);

//            组合数
            if (n == 0) {
                results.add("");
            } else {
                for (int i = 0; i < n; i++) {
                    for (String left : generateParenthesis(i)) {
                        for (String right : generateParenthesis(n - 1 - i)) {
                            results.add("(" + left + ")" + right);
                        }
                    }
                }
            }

            return results;
        }


//        回溯法
        private static void backtrack(List<String> ans, String cur, int open, int close, int max) {
            if (2 * max == cur.length()) {
                ans.add(cur);
            }
            if (open < max) {
                backtrack(ans, cur + '(', open + 1, close, max);
            }
            if (close < open) {
                backtrack(ans, cur + ')', open, close + 1, max);
            }
        }

//        暴力法
        private static void generateALl(char[] current, int pos, List<String> results) {
            if (pos == current.length) {
                if (valid(current)) {
                    results.add(new String(current));
                }
            } else {
                current[pos] = '(';
                generateALl(current, pos + 1, results);
                current[pos] = ')';
                generateALl(current, pos + 1, results);
            }

        }

//        判断是否正确
        private static boolean valid(char[] current) {
            int balance = 0;
            for (char aCurrent : current) {
                if (aCurrent == '(') {
                    balance = balance + 1;
                } else {
                    balance = balance - 1;
                    if (balance < 0) {
                        return false;
                    }
                }
            }
            return balance == 0;
        }
    }
}
