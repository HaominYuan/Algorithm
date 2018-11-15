package leetcode;


public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3};
        System.out.println(Solution.search(nums, 3));
    }


    static class Solution {
        static int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}



