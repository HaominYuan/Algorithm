package leetcode;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(6));
    }

    static class Solution {
        public boolean isUgly(int num) {
            if (num <= 0) {
                return false;
            }
            while (num % 2 == 0) {
                num = num / 2;
            }

            while (num % 3 == 0) {
                num = num / 3;
            }

            while (num % 5 == 0) {
                num = num / 5;
            }

            return num == 1;
        }
    }
}
