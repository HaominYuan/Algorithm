package leetcode;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(new MySolution().maxSubArray(new int[]{-2, 1, -3, 4}));
    }


    static class MySolution {
        public int maxSubArray(int[] nums) {
            int maxScore = Integer.MIN_VALUE;
            int now = 0;
            for (int num : nums) {
                maxScore = Math.max(maxScore, num);
                if ((now = now + num) > 0) {
                    maxScore = Math.max(maxScore, now);
                } else {
                    now = 0;
                }
            }
            return maxScore;
        }
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int curSum = 0;
            for (int num : nums) {
                curSum = curSum + num;

                maxSum = Math.max(maxSum, curSum);
                curSum = Math.max(curSum, 0);
            }
            return maxSum;
        }
    }
}
