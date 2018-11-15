package leetcode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2 ,3 ,4 ,5}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int sum = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < prices[i - 1]) {
                    sum = sum + prices[i - 1] - min;
                    min = prices[i];
                }
            }
            return sum + prices[prices.length - 1] - min;
        }
    }
}
