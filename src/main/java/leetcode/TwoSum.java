package leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Description: java类作用描述
 * @Author: Tst
 * @CreateDate: 2018/7/22 上午2:06
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        nums = new Solution().twoSum(nums, 9);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    /**
     * 两遍循环
     * 时间复杂度o(n)
     */
    class MySolution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
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




