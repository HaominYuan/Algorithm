package leetcode;

import java.util.Arrays;

public class StraightInPlayingCards {
    public static void main(String[] args) {
        System.out.println(new Solution().isStraight(new int[]{0, 2, 7, 4, 5}));
    }

    static class Solution {
        public boolean isStraight(int[] nums) {
            if (nums == null || nums.length != 5) {
                return false;
            }
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    sum = sum + 1;
                } else if (i + 1 < nums.length) {
                    sum = sum - (nums[i + 1] - nums[i] - 1);
                }
            }
            return sum >= 0;
        }

    }
}
