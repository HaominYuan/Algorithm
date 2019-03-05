package leetcode;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }

    static class Solution {

        public int climbStairs(int n) {
//            if (n == 1) {
//                return 1;
//            } else if (n == 2) {
//                return 2;
//            } else {
//                int ppp = 1;
//                int pp = 2;
//                int p = 0;
//                for (int i = 3; i <= n; i++) {
//                    p = ppp + pp;
//                    ppp = pp;
//                    pp = p;
//                }
//                return p;
//            }
            n = n + 1;
            return (int) ((Math.pow(1.618033988749895, n) - Math.pow(-0.6180339887498949, n)) / 2.23606797749979 + 0.5);

        }
    }
}
