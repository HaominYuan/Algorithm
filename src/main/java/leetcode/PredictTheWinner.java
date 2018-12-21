package leetcode;

public class PredictTheWinner {
    public static void main(String[] args) {
        System.out.println(new Solution().PredictTheWinner(new int[]{10, 2, 3}));
    }

    static class Solution {
        public boolean PredictTheWinner(int[] nums) {
            int[][] scores = new int[nums.length][nums.length];
            scores[nums.length - 1][nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = i; j < nums.length; j++) {
                    if (i == j) {
                        scores[i][i] = nums[i];
                    } else {
                        scores[i][j] = Math.max(nums[i] - scores[i + 1][j], nums[j] - scores[i][j - 1]);
                    }
                }
            }
            return scores[0][nums.length - 1] >= 0;
        }
    }
}
