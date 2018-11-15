package leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(Solution.reverse(-2147483648));
//        System.out.println(MySolution.reverse(-123));
    }



    static class Solution {
        static int reverse(int x) {
            long temp = x;
            boolean flag = false;
            if (x < 0) {
                temp = -temp;
                flag = true;
            }
            long sum = 0;
            do {
                sum = sum * 10 + temp % 10;
                temp = temp / 10;
            } while (temp > 0);
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
            if (flag) {
                sum = -sum;
            }
            return (int)sum;
        }
    }
}
