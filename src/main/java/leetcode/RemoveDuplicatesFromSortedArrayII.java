package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int start = 1;
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] != nums[start] || nums[i] != nums[start - 1]) {
                    nums[++start] = nums[i];
                }
            }
            return start + 1;
        }
    }
}
