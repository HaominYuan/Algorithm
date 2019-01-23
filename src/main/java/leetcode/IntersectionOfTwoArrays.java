package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    static class MySolution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums2.length; i++) {
                if ((i == 0 || nums2[i] != nums2[i - 1]) && find(nums1, nums2[i])) {
                    list.add(nums2[i]);
                }
            }
            int[] result = new int[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        boolean find(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left != nums.length && nums[left] == target;
        }
    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            // 寻找范围
            for (int num1 : nums1) {
                max = Math.max(num1, max);
                min = Math.min(num1, min);
            }

            // true 表示这个点在nums1中被提示过
            boolean[] marks = new boolean[max - min + 1];
            for (int num1 : nums1) {
                marks[num1 - min] = true;
            }

            int index = 0;
            for (int num2 : nums2) {

                // 在范围之外
                if (num2 < min || num2 > max) {
                    continue;
                }

                // 在这个范围之内的点
                if (marks[num2 - min]) {
                    nums2[index++] = num2; // 合理使用 nums2 数组，将符合条件的数放到 nums2 的前面索引位置
                    marks[num2 - min] = false; // 设置 false，重复的数字就会被过滤掉，设置为false进不来
                }
            }

            return Arrays.copyOf(nums2, index); // 取 num2 数组从 0 开始 index 长度的子数组
        }
    }
}
