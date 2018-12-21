package leetcode;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(10));
    }

    static class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count = count + 1;
                n = n & (n - 1);
            }
            return count;
        }
    }
}
