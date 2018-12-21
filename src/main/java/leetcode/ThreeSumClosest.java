package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] ints = new int[]{-1, 2, 1, -4};
        ints = new int[]{0, 2, 1, -3};
        System.out.println(Solution.threeSumClosest(ints, 1));
    }


    static class Solution {
        static int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            boolean symbol = false;
            int closest = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        if (target - (nums[i] + nums[j] + nums[k]) < closest) {
                            closest = target - (nums[i] + nums[j] + nums[k]);
                            symbol = false;
                        }
                        j = j + 1;
                    } else if (nums[i] + nums[j] + nums[k] > target) {
                        if (nums[i] + nums[j] + nums[k] - target < closest) {
                            closest = nums[i] + nums[j] + nums[k] - target;
                            symbol = true;
                        }
                        k = k - 1;
                    } else {
                        return target;
                    }
                }
            }
            if (symbol) {
                return target + closest;
            } else {
                return target - closest;
            }
        }
    }

}
