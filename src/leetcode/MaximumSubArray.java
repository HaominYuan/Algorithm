package leetcode;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray2(new int[]{-2, 1, -3, 4}));
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

        public int maxSubArray2(int[] nums) {
            return func(nums, 0, nums.length - 1);
        }


        public int func(int[] nums, int begin, int end) {
            if (begin == end) {
                return nums[begin];
            }
            int mid = (begin + end) / 2;
            int left = func(nums, begin, mid);
            int right = func(nums, mid + 1, end);
            if (left >= 0 && right >= 0) {
                return left + right;
            }
            if (left >= 0) {
                return left;
            }
            if (right >= 0) {
                return right;
            }
            return left > right ? left : right;
        }
    }
}
