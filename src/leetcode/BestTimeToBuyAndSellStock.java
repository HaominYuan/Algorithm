package leetcode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(new MySolution().maxProfit(new int[]{1, 2 ,3 ,4 ,5}));
    }

    static class MySolution {
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

    class Solution {
        public int maxProfit(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            int i = 0;
            int max = 0;
            while(i < nums.length){
                //找到附近最小的数
                while(i < nums.length - 1 && nums[i+1] <= nums[i])
                    i++;
                int min = nums[i];
                //找到附近最大的数
                while(i < nums.length - 1 && nums[i+1] >= nums[i])
                    i++;
                max += (i < nums.length) ? (nums[i++] - min) : 0;
            }
            return max;
        }
    }
}
