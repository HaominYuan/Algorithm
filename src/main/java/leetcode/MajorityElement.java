package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3, 3, 4}));
    }

    static class Solution_1 {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    static class Solution_2 {
        public int majorityElement(int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            int max = 0;
            int maxKey = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    maxKey = entry.getKey();
                    max = entry.getValue();
                }
            }
            return maxKey;
        }
    }

    static class Solution_3 {
        public int majorityElement(int[] nums) {
            int start = 0, end = nums.length - 1;
            int mid = (start + end) / 2, partition;
            while ((partition = partition_1(nums, start, end)) != mid) {
                if (partition < mid) {
                    start = partition + 1;
                } else {
                    end = partition - 1;
                }
            }
            return nums[mid];
        }

        private int partition_1(int[] nums, int start, int end) {
            int index = start, tmp;
            for (int i = start; i < end; i++) {
                if (nums[i] < nums[end]) {
                    tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    index = index + 1;
                }
            }
            tmp = nums[end];
            nums[end] = nums[index];
            nums[index] = tmp;
            return index;
        }

        private int partition_2(int[] nums, int start, int end) {
            int pivot = nums[start];
            while (start < end) {
                while (start < end && nums[end] >= pivot) {
                    end = end - 1;
                }
                nums[start] = nums[end];
                while (start < end && nums[start] < pivot){
                    start = start + 1;
                }
                nums[end] = nums[start];
            }
            nums[start] = pivot;
            return start;
        }
    }


    static class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int value = nums[0], time = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == value) {
                    time = time + 1;
                } else {
                    if (time == 0) {
                        value = nums[i];
                        time = 1;
                    }
                    time = time - 1;
                }
            }
            return value;
        }
    }



}
