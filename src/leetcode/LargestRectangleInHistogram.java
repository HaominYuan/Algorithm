package leetcode;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    static class Solution {
        int max = 0;

        public int largestRectangleArea(int[] heights) {
            func(heights, 0, heights.length - 1);
            return max;
        }


        void func(int[] heights, int left, int right) {

            if (left > right) {
                return;
            }

            if (left == right) {
                max = Math.max(max, heights[left]);
            }
            int index = left;
            boolean sorted = true;
            for (int i = left + 1; i <= right; i++) {
                if (heights[i] < heights[i - 1]) {
                    sorted = false;
                }
                if (heights[i] < heights[index]) {
                    index = i;
                }
            }

            if (sorted) {
                for (int i = left; i <= right; i++) {
                    max = Math.max(max, heights[i] * (right - i + 1));
                }
            } else {
                max = Math.max((right - left + 1) * heights[index], max);
                func(heights, left, index - 1);
                func(heights, index + 1, right);
            }
        }
    }
}
