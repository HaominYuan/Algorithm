package leetcode;

public class DivideTwoInteger {

    public static void main(String[] args) {

        System.out.println(Solution.divide(1004958205, -2137325331));
    }



    static class Solution {
        static int divide(int dividend, int divisor) {

            boolean flag = true;
            if (dividend > 0) {
                dividend = -dividend;
                flag = false;
            }
            if (divisor > 0) {
                divisor = -divisor;
                flag = !flag;
            }

            int count = 0;

            if (divisor < dividend) {
                return 0;
            }

            for (int i = 30; i >= 0; i--) {
                if (divisor << i > 0) {
                    continue;
                }
                while (true) {
                    if ((dividend = dividend - (divisor << i)) <= 0) {
                        count = count + (1 << i);
                        if (dividend == 0) {
                            break;
                        }
                    } else {
                        dividend = dividend + (divisor << i);
                        break;
                    }
                }
            }

            if (!flag) {
                count = -count;
            }

            if (flag && count < 0) {
                return Integer.MAX_VALUE;
            }


            return count;
        }


    }
}
