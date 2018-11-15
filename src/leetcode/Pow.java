package leetcode;

public class Pow {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, -2));
    }


    static class Solution {
        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            } else if (n == 0) {
                return 1;
            }

            double result = 1;
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    result = result * x;
                }
            } else if (n < 0) {
                for (int i = 0; i < -n; i++) {
                    result = result / x;
                }
            }
            return result;
        }
    }
}
