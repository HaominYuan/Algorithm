package leetcode;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4}));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int maxScore = Integer.MIN_VALUE;
            int now = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > maxScore) {
                    maxScore = nums[i];
                }
                if (now + nums[i] > 0) {
                    now = now + nums[i];
                    if (now > maxScore) {
                        maxScore = now;
                    }
                } else {
                    now = 0;
                }
            }
            return maxScore;
        }
    }

    static class newSolution {
        public int maxSubArray(int[] nums) {
            int maxScore = Integer.MIN_VALUE;
            int now = 0;
            for (int i = 0; i < nums.length; i++) {
                maxScore = Math.max(maxScore, nums[i]);
                if ((now = now + nums[i]) > 0) {
                    maxScore = Math.max(maxScore, now);
                } else {
                    now = 0;
                }
            }
            return maxScore;
        }
    }
}
