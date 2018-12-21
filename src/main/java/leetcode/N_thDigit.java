package leetcode;

public class N_thDigit {
    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(999999999));
    }

    static class Solution {
        public int findNthDigit(int n) {
            long x = 9L;
            long base = 1L;
            long len = 1;
            long copy = n;
            while (copy > x * base * len) {
                copy = copy - x * base * len;
                len = len + 1;
                base = base * 10;
            }
            long number = base + (copy - 1) / len;
            for (int i = 0; i < len - 1 - ((copy - 1) % len); i++) {
                number = number / 10;
            }
            return (int) number % 10;
        }
    }
}
