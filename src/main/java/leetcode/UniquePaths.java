package leetcode;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(10, 10));
    }

    static class Solution {
        public int uniquePaths(int m, int n) {
            if (m > n) {
                int temp = m;
                m = n;
                n = temp;
            }

            double result = 1;
            for (int i = 0, j = m + n - 2; i < m - 1; i++, j--) {
                result = result * j;
            }


            for (int i = m - 1; i > 1; i--) {
                result = result / i;
            }

            return (int) result;
        }
    }
}
