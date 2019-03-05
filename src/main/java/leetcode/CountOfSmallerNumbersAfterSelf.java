package leetcode;

import java.util.Arrays;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countSmaller(new int[]{5, 4, 3, 2})));
    }

    static class Solution {
        private int sum = 0;
        public int[] countSmaller(int[] nums) {
            func(nums, 0, nums.length - 1);
            System.out.println(sum);
            return nums;
        }

        void func(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int mid = (left + right) / 2;
            func(nums, left, mid);
            func(nums, mid + 1, right);
            merge(nums, left, mid + 1, right);
        }


        void merge(int[] nums, int left, int mid, int right) {
            while (left < mid && mid <= right) {
                while (left < mid && nums[left] <= nums[mid]) {
                    left = left + 1;
                }
                int copy = mid;
                while (mid <= right && nums[mid] < nums[left]) {
                    mid = mid + 1;
                    sum = sum + copy - left;
                }
                convert(nums, left, copy, mid);
                left = left + mid - copy;
            }
        }

        void convert(int[] nums, int left, int mid, int right) {
            reverse(nums, left, mid - 1);
            reverse(nums, mid, right - 1);
            reverse(nums, left, right - 1);
        }


        void reverse(int[] nums, int left, int right) {
            while (left < right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }


    }
}
