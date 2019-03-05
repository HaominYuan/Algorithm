package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        int instance = 121;
        System.out.println(Solution.isPalindrome(instance));
        instance = -121;
        System.out.println(Solution.isPalindrome(instance));
        instance = 10;
        System.out.println(Solution.isPalindrome(instance));
    }

    static class Solution {
        static boolean isPalindrome(int x) {
            if (x < 0 || x % 10 == 0) {
                return false;
            } else {
                int copy = x;
                int sum = 0;
                do {
                    sum = sum * 10 + copy % 10;
                    copy = copy / 10;
                } while (copy != 0);
                return sum == x;
            }
        }
    }

}
