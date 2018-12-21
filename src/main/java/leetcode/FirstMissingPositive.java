package leetcode;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(new Solution().firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{7, 8, 9, 11}));
        System.out.println(new Solution().firstMissingPositive(new int[]{1, 1}));
    }

    static class Solution {
        int length;

        int firstMissingPositive(int[] nums) {
            length = nums.length;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                nums[i] = -1;
                arrange(nums, num);
            }
            for (int i = 0; i < nums.length; i++) {
                if (!(isLegal(nums[i]) && nums[i] == i + 1)) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        void arrange(int[] nums, int value) {
            if (isLegal(value) && nums[value - 1] != value) {

                int temp = nums[value - 1];
                nums[value - 1] = value;
                arrange(nums, temp);
            }
        }

        boolean isLegal(int value) {

            return 0 < value && value <= length;
        }
    }
}
