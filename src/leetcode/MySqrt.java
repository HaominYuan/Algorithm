package leetcode;

public class MySqrt {
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(4));
    }

    static class Solution {
        public int mySqrt(int x) {
            double zeroPoint = 1;
            double temp;
            while ((temp = Math.abs(Math.pow(zeroPoint, 2) - x)) >= 1) {
                zeroPoint = zeroPoint - (Math.pow(zeroPoint, 2) - x) / 2 / zeroPoint;
            }
            return Math.pow((int) zeroPoint, 2) > x ? (int) (zeroPoint) - 1 : (int) (zeroPoint);
        }
    }
}
