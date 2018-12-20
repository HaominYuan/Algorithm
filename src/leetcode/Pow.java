package leetcode;

public class Pow {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 3));
    }


    static class MySolution {
        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            if (n < 0) {
                x = 1 / x;
                n = -n;
            }
            double result = 1;
            double base = x;
            while (n != 0) {
                if ((n & 1) != 0) {
                    result = result * base;
                }
                base = base * base;
                n = n >>> 1;
            }
            return result;
        }
    }

    static class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }

            if (n > 0) {
                if (n == 1) return x;
                if ((n & 1) == 0) {
                    return myPow(x * x, n >> 2);
                }
                return x * myPow(x, n - 1);
            }

            if (n == -1) {
                return 1 / x;
            }

            // 如果等于零那么向右
            if ((n & 1) == 0) {
                return myPow(x * x, n >> 2);
            }
            // 如果最后一位是一那么加上一
            return 1 / x * myPow(x, n + 1);
        }
    }
}
