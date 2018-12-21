package leetcode;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(new Solution().consecutiveNumbersSum(15));
    }

    static class NaiveSolution {
        public int consecutiveNumbersSum(int N) {
            int sum = 1, small = 1, big = 2, limit = (1 + N) / 2, curSum = small + big;
            while (small < limit) {
                if (curSum == N) {
                    sum = sum + 1;
                }
                while (curSum > N && small < limit) {
                    curSum = curSum - small;
                    small = small + 1;
                    if (curSum == N) {
                        sum = sum + 1;
                    }
                }
                big = big + 1;
                curSum = curSum + big;

            }
            return sum;
        }
    }


    static class Solution {
        public int consecutiveNumbersSum(int N) {
            while ((N & 1) == 0) N >>= 1;
            int ans = 1, d = 3;

            while (d * d <= N) {
                int e = 0;
                while (N % d == 0) {
                    N /= d;
                    e++;
                }
                ans *= e + 1;
                d += 2;
            }

            if (N > 1) ans <<= 1;
            return ans;
        }
    }
}

