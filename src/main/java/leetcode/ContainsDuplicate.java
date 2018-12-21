package leetcode;

import java.util.Arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(new Solution().containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    static class Solution {
        boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for(int i = 0; i < nums.length-1; i++) {
                if(nums[i] == nums[i+1]) {
                    return true;
                }
            }
            return false;
        }
    }
}
