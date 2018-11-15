package leetcode.子集_组合_序列;

public class CombinationSumIV {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    static class Solution {
        int sum = 0;
        public int combinationSum4(int[] nums, int target) {
            func(nums, target);
            return sum;
        }

        void func(int[] nums, int target) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                sum = sum + 1;
            }

            for (int num : nums) {
                func(nums, target - num);
            }
        }
    }
}
