package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("0", "52"));
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.length() < num2.length()) {
                String temp = num1;
                num1 = num2;
                num2 = temp;
            }


            List<String> list = new ArrayList<>();
            for (int i = 0; i < num2.length(); i++) {
                list.add(mul(num1, num2.charAt(i), num2.length() - 1 - i));
            }
            String result = "";
            for (int i = 0; i < list.size(); i++) {
                result = add(result, list.get(i));
            }
            return result;
        }

        String add(String x, String y) {
            if (x.length() < y.length()) {
                String temp = x;
                x = y;
                y = temp;
            }
            int diff = x.length() - y.length();
            StringBuilder result = new StringBuilder();
            int i;
            int tenDigit = 0;
            for (i = y.length() - 1; i >= 0; i--) {
                int num1 = x.charAt(i + diff) - '0';
                int num2 = y.charAt(i) - '0';
                int sum = num1 + num2 + tenDigit;
                tenDigit = sum / 10;
                int singleDigit = sum % 10;
                result.insert(0, singleDigit);
            }
            if (x.length() - y.length() == 0 && tenDigit != 0) {
                result.insert(0, tenDigit);
            } else {
                for (int j = x.length() - y.length() - 1; j >= 0; j--) {
                    int sum = tenDigit + (x.charAt(j) - '0');
                    tenDigit = sum / 10;
                    int singleDigit = sum % 10;
                    result.insert(0, singleDigit);
                }
                if (tenDigit != 0) {
                    result.insert(0, tenDigit);
                }
            }
            return result.toString();
        }

        String mul(String num1, char c, int offset) {
            if (c == '0') {
                return "0";
            }
            StringBuilder result = new StringBuilder();
            int tenDigit = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int temp = num1.charAt(i) - '0';
                int product = temp * (c - '0') + tenDigit;
                tenDigit = product / 10;
                int singleDigit = product % 10;
                result.insert(0, singleDigit);
            }
            if (tenDigit != 0) {
                result.insert(0, tenDigit);
            }
            for (int i = 0; i < offset; i++) {
                result.append('0');
            }
            return result.toString();
        }
    }
}
