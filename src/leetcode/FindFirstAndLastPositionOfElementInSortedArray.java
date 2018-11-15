package leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(Solution.searchRange(nums, 8)));
    }

    static class Solution {
        static int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            return search(nums, target, 0, nums.length - 1);
        }

        static int[] search(int[] nums, int target, int left, int right) {
            if (left > right) {
                return new int[]{-1, -1};
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int temp1, temp2;
                int[] x1 = search(nums, target, left, mid - 1);
                int[] x2 = search(nums, target, mid + 1, right);
                if (x1[0] == -1) {
                    temp1 = mid;
                }else{
                    temp1 = x1[0];
                }
                if (x2[0] == -1) {
                    temp2 = mid;
                } else {
                    temp2 = x2[1];
                }

                return new int[]{temp1, temp2};


            } else if (nums[mid] < target) {
                return search(nums, target, mid + 1, right);
            } else {
                return search(nums, target, left, mid - 1);
            }
        }
    }
}
