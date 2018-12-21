package leetcode;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            int reach = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > reach || reach >= nums.length - 1) break;
                reach = Math.max(reach, i + nums[i]);
            }
            return reach >= nums.length - 1;
        }
    }
}
