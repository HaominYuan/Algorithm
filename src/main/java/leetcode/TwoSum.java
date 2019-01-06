package leetcode;

import java.util.HashMap;
import java.util.List;


public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        nums = new Solution().twoSum(nums, 9);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 将思维转变成没看到一个nums[i]则在已经知道的元素中查询有没有他的complement
     * 用HashMap<Integer, Integer>来储存已经看到的元素。其中key为元素，value为坐标
     * 获取结果时注意先后顺序
     * 时间复杂度o(n)
     */
    static class Solution {
        int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}




