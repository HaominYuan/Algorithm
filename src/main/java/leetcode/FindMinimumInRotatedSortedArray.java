package leetcode;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new Solution().findMin1(new int[]{1}));
    }

    static class Solution {
        public int findMin1(int[] nums) {
            int begin = 0, end = nums.length - 1, mid = begin;
            while (nums[begin] > nums[end]) {
                if (end - begin == 1) {
                    mid = end;
                    break;
                }
                mid = (begin + end) / 2;

                if (nums[begin] == nums[end] && nums[begin] == nums[mid]) {
                    int min = nums[begin];
                    for (int i = begin + 1; i <= end; i++) {
                        min = Math.min(min, nums[i]);
                    }
                    return min;
                }

                if (nums[begin] <= nums[mid]) {
                    begin = mid;
                } else {
                    end = mid;
                }
            }
            return nums[mid];
        }

        public int findMin2(int[] nums) {
            int temp = nums[0];
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[j - 1]) {
                    return Math.min(temp, nums[j]);
                }
            }
            return temp;
        }
    }
}
