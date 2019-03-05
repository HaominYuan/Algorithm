package leetcode;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 1}));
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int test = 0;
            for (int i = nums.length - 1; i >= 0; --i) {
                test ^= nums[i];
            }
            return test;
        }
    }
}
