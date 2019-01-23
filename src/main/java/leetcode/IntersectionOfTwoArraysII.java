package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    static class MySolution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Wrap> hashMap = new HashMap<>();
            for (int num : nums1) {
                Wrap wrap = hashMap.get(num);
                if (wrap == null) {
                    wrap = new Wrap();
                    hashMap.put(num, wrap);
                }
                wrap.time = wrap.time + 1;
            }

            int index = 0;
            for (int num : nums2) {
                Wrap wrap = hashMap.get(num);
                if (wrap != null && wrap.time > 0) {
                    wrap.time = wrap.time - 1;
                    nums2[index++] = num;
                }
            }
            return Arrays.copyOf(nums2, index);
        }

        class Wrap {
            int time;


            public Wrap() {
                this(0);
            }

            public Wrap(int time) {
                this.time = time;
            }

        }
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length == 0 || nums2.length == 0) {
                return new int[0];
            }
            int[] result = new int[Math.max(nums1.length, nums2.length)];
            int index = 0;
            boolean[] marked = new boolean[result.length];
            for (int num : nums2) {
                int start = 0;
                while ((start = find(nums1, num, start)) != -1) {
                    if (!marked[start]) {
                        result[index++] = num;
                        marked[start] = true;
                        break;
                    }
                    start++;
                }
            }
            return Arrays.copyOf(result, index);
        }

        private int find(int[] nums, int val, int start) {
            for (; start < nums.length; start++) {
                if (nums[start] == val) {
                    return start;
                }
            }
            return -1;
        }

    }
}
