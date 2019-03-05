package leetcode;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 10));
    }

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int[] status = new int[amount + 1];
            // 排序是为了减少遍历的可能性
            Arrays.sort(coins);
            // 首先设置所有状态下的硬币数量都为无穷大。这里用amount + 1 表示无穷大
            Arrays.fill(status, amount + 1);
            // 零元表示只用零个硬币
            status[0] = 0;
            // 下面表示从1元开始用几个硬币
            for (int i = 1; i <= amount; i++) {
                // 所有硬币的所有可能性，取其中最好。
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        status[i] = Math.min(status[i], status[i - coin] + 1);
                    } else {
                        break;
                    }
                }
            }
            return status[amount] == amount + 1 ? -1 : status[amount];
        }
    }
}
