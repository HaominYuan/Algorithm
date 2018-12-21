package leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(Solution.searchInsert(nums, 7));
    }

    static class Solution {
        static int searchInsert(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
