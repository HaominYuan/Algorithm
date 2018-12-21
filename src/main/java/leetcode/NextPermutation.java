package leetcode;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        Solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        static void nextPermutation(int[] nums) {
            int i, j;
            for (i = nums.length - 1; i > 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    for (j = nums.length - 1; j >= i; j--) {
                        if (nums[i - 1] < nums[j]) {
                            swap(nums, i-1, j);
                            break;
                        }
                    }
                    break;
                }
            }
            j = nums.length - 1;
            while (i < j) {
                swap(nums, i++, j--);
            }
        }

        static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
