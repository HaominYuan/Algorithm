package leetcode;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("6", "501"));
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            int s = 0;
            StringBuilder result = new StringBuilder();
            int length = Math.min(num1.length(), num2.length());
            int i;
            for (i = 1; i <= length; i++) {
                int sum = (num1.charAt(num1.length() - i) - '0') + (num2.charAt(num2.length() - i) - '0') + s;
                s = sum / 10;
                result.insert(0, sum % 10);
            }

            while (num1.length() - i >= 0) {
                int sum = (num1.charAt(num1.length() - i) - '0') + s;
                s = sum / 10;
                result.insert(0, sum % 10);
                i = i + 1;
            }

            while (num2.length() - i >= 0) {
                int sum = (num2.charAt(num2.length() - i) - '0') + s;
                s = sum / 10;
                result.insert(0, sum % 10);
                i = i + 1;
            }

            if (s != 0) {
                result.insert(0, s);
            }
            return result.toString();
        }
    }
}
