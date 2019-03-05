package leetcode;

public class CoinChangeII {
    public static void main(String[] args) {
        System.out.println(new Solution().change(new int[]{1, 2, 5}, 5));
    }

    static class Solution {
        public int change(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            // 注意两层循环的嵌套
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
            return dp[amount];
        }
    }
}
