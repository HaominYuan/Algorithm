package leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new Solution().searchRange(nums, 1)));
    }


    static class Solution_R {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int[] range = new int[2];
            range[0] = nums.length;
            range[1] = -1;
            search(nums, 0, nums.length - 1, target, range);
            if (range[0] == nums.length) {
                range[0] = -1;
            }
            return range;
        }

        void search(int[] nums, int left, int right, int target, int[] range) {
            if (left > right || nums[right] < target || target < nums[left]) {
                return;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (nums[left] != target) {
                    search(nums, left, mid - 1, target, range);
                } else {
                    range[0] = Math.min(range[0], left);
                    range[1] = Math.max(range[1], left);
                }

                if (nums[right] != target) {
                    search(nums, mid + 1, right, target, range);
                } else {
                    range[0] = Math.min(range[0], right);
                    range[1] = Math.max(range[1], right);
                }
                range[0] = Math.min(range[0], mid);
                range[1] = Math.max(range[1], mid);

            } else if (target < nums[mid]) {
                search(nums, left, mid - 1, target, range);
            } else {
                search(nums, mid + 1, right, target, range);
            }


        }
    }


    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] range = new int[2];
            range[0] = searchFirst(nums, target);
            range[1] = searchLast(nums, target);
            return range;
        }

        int searchFirst(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    if (mid - 1 == -1 || nums[mid - 1] != target) {
                        return mid;
                    }
                    right = mid - 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        int searchLast(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    if (mid + 1 == nums.length || nums[mid + 1] != target) {
                        return mid;
                    }
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }


}
