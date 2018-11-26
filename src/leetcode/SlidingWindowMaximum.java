package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{5, 3, 6, 7}, 3)));
    }

    static class MySolution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) {
                return new int[nums.length - k + 1];
            }

            int[] max = new int[nums.length - k + 1];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                if (queue.isEmpty()) {
                    queue.add(i);
                } else {
                    while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                        queue.removeLast();
                    }
                    queue.add(i);
                }
            }

            for (int i = k, j = 0; i < nums.length; i++) {
                max[j++] = nums[queue.getFirst()];
                if (i - queue.getFirst() == k) {
                    queue.removeFirst();
                }
                while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                    queue.removeLast();
                }
                queue.add(i);
            }
            max[max.length - 1] = nums[queue.getFirst()];
            return max;
        }
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 如果为空
            if (nums.length == 0 || k == 0) {
                return new int[0];
            }

            int result[] = new int[nums.length - k + 1];

            result[0] = Integer.MIN_VALUE;
            int p = -1;
            for (int i = 0; i < k; i++) {
                if (nums[i] > result[0]) {
                    p = i;
                    result[0] = nums[i];
                }
            }

            int start = 0, last = k - 1;
            for (int j = 1; j < result.length; j++) {
                start = start + 1;
                last = last + 1;
                // 最大的数字还在窗口中
                if (p >= start) {
                    // 新进来的数字大于等于目前的最大数
                    if (nums[last] >= nums[p]) {
                        p = last;
                        result[j] = nums[last];
                    } else {
                        result[j] = nums[p];
                    }
                } else {
                    // 新进来的数字大于包括刚刚出去的最大数字
                    if (nums[last] >= nums[p]) {
                        p = last;
                        result[j] = nums[last];
                    } else {
                        // 重新找
                        p = last;
                        result[j] = nums[last];
                        for (int m = start; m < last; m++) {
                            if (nums[m] > result[j]) {
                                result[j] = nums[m];
                                p = m;
                            }
                        }
                    }

                }
            }
            return result;
        }
    }
}
