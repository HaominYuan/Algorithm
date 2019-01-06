package leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 13));
    }

    static class MySolution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (nums[middle] == target) {
                    return middle;
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return -1;
        }
    }

    static class Solution {
        public int search(int[] nums, int target) {
            // 左闭右开
            int left = 0, right = nums.length;
            while (left < right) {
                // 防止溢出
                int mid = left + (right - left) / 2;
                // 这里不要等号时因为可能左边有和target相等的元素
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left == nums.length || nums[left] != target ? -1 : left;
        }
    }
}
