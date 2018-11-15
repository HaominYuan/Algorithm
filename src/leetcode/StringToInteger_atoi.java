package leetcode;

public class StringToInteger_atoi {
    public static void main(String[] args) {
        String instance = "+42";
        System.out.println(Solution.myAtoi(instance));
        instance = "   -42";
        System.out.println(Solution.myAtoi(instance));
        instance = "4193 with words";
        System.out.println(Solution.myAtoi(instance));
        instance = "words and 987";
        System.out.println(Solution.myAtoi(instance));
        instance = "-91283472332";
        System.out.println(Solution.myAtoi(instance));
    }


    static class Solution {
        static int myAtoi(String str) {
            double result = 0;
            boolean symbol = false;
            boolean begin = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    if (!begin) {
                        break;
                    }
                } else if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                    begin = false;
                    if (symbol) {
                        result = result * 10 - (str.charAt(i) - 48);
                    } else {
                        result = result * 10 + str.charAt(i) - 48;
                    }
                } else if (str.charAt(i) == '-') {
                    if (!begin) {
                        break;
                    }
                    symbol = true;
                    begin = false;
                } else if (str.charAt(i) == '+') {
                    if (!begin) {
                        break;
                    }
                    begin = false;
                } else {
                    break;
                }
            }
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) result;
        }
    }
}
