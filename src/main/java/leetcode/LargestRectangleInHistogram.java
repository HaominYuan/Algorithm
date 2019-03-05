package leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    static class MySolution {
        public int largestRectangleArea(int[] heights) {
            return func(heights, 0, heights.length - 1);
        }

        private int func(int[] heights, int left, int right) {
            if (left > right) {
                return 0;
            }

            if (left == right) {
                return heights[left];
            }

            int minIndex = left;
            boolean isAscending = true;
            boolean isDescending = true;

            for (int i = left + 1; i <= right; i++) {
                if (isDescending && heights[i - 1] < heights[i]) {
                    isDescending = false;
                } else if (isAscending && heights[i - 1] > heights[i]) {
                    isAscending = false;
                }

                if (heights[minIndex] > heights[i]) {
                    minIndex = i;
                }
            }

            int max = Integer.MIN_VALUE;
            if (isAscending) {
                for (int i = left; i <= right; i++) {
                    max = Math.max(max, (right - i + 1) * heights[i]);
                }
            } else if (isDescending) {
                for (int i = right; i >= left; i--) {
                    max = Math.max(max, (i - left + 1) * heights[i]);
                }
            } else {
                max = Math.max(max, (right - left + 1) * heights[minIndex]);
                max = Math.max(max, func(heights, left, minIndex - 1));
                max = Math.max(max, func(heights, minIndex + 1, right));
            }
            return max;
        }
    }

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    int index = stack.pop();
                    int k = stack.isEmpty() ? -1 : stack.peek();
                    // 两边都是开区间
                    max = Math.max(max, heights[index] * (i - k - 1));
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int index = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();

                max = Math.max(max, heights[index] * (heights.length - k - 1));
            }
            return max;
        }

    }



}
