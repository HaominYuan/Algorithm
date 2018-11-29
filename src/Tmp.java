
public class Tmp {
    public static void main(String[] args) {
        System.out.println(new Solution().func(new int[]{7, 1, 5, 3, 6, 4}));

    }

    static class Solution {

        public int func(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }
            int profit = 0, begin = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i - 1] > prices[i]) {
                    profit = profit + prices[i - 1] - begin;
                    begin = prices[i];
                }
            }
            int temp = prices[prices.length - 1] - begin;
            if (temp > 0) {
                profit = profit + temp;
            }
            return profit;
        }
    }
}
