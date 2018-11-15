package leetcode;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{1, 3, 1, 1, 1}, 3));
    }

    static class Solution {
        public boolean search(int[] nums, int target) {
            if (nums.length == 0) {
                return false;
            }
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[left] == target || nums[mid] == target || nums[right] == target) {
                    return true;
                }
                if (nums[left] == nums[mid]) {
                    left = left + 1;
                } else if (nums[mid] == nums[right]) {
                    right = right - 1;
                } else if (nums[left] < nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] < nums[right]) {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return false;
        }
    }
}
