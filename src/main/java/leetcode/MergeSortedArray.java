package leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    private static void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }
    }

    static class MySolution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            System.arraycopy(nums2, 0, nums1, m, n);

            int i = 0, j = nums1.length - nums2.length;
            while (i < j && j < nums1.length) {
                int copy = j;
                while (i < j && nums1[i] <= nums1[j]) {
                    i = i + 1;
                }

                while (j < nums1.length && nums1[i] > nums1[j]) {
                    j = j + 1;
                }
                exchange(nums1, i, copy, j - 1);
                i = i + j - copy;
            }
        }

        void exchange(int[] nums, int begin, int mid, int end) {
            reverse(nums, begin, mid - 1);
            reverse(nums, mid, end);
            reverse(nums, begin, end);
        }


    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            reverse(nums1, 0, m - 1);
            int i = m - 1, j = 0, k = nums1.length - 1;
            while (i >= 0 && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j++];
                }
            }


            while (j < nums2.length) {
                nums1[k--] = nums2[j++];
            }


            reverse(nums1, 0, nums1.length - 1);
        }


    }


}
