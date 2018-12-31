package leetcode.程序员代码面试指南.栈和队列.生成最大窗口值;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println((Arrays.toString(maxSlidingWindow(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3))));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("数组为空");
        }

        if (k <= 0) {
            throw new IllegalArgumentException("窗口的大小小于等于零");
        }

        if (k > nums.length) {
            throw new IllegalArgumentException("窗口的大小大于数组的长度");
        }

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int[] max = new int[nums.length - k + 1];

        // 初始化
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.offer(i);
        }

//        while (!queue.isEmpty()) {
//            System.out.println(nums[queue.pop()]);
//        }

        for (int i = k, j = 0; i < nums.length; i++, j++) {
            int index = queue.peek();
            if (j == index) {
                queue.poll();
            }
            max[j] = nums[index];

            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.offer(i);
        }
        max[max.length - 1] = nums[queue.peek()];

        return max;
    }
}
