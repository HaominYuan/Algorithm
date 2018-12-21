package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(Solution.fourSum(nums, 0));
    }

    static class Solution {
        static List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> results = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int begin = j + 1, end = nums.length - 1;
                    while (begin < end) {
                        int temp = nums[i] + nums[j] + nums[begin] + nums[end];
                        if (temp > target) {
                            end = end - 1;
                        } else if (temp < target) {
                            begin = begin + 1;
                        } else {
                            List<Integer> result = new ArrayList<>();
                            result.add(nums[i]);
                            result.add(nums[j]);
                            result.add(nums[begin]);
                            result.add(nums[end]);
                            results.add(result);
                            begin = begin + 1;
                        }
                    }
                }
            }
            results = results.stream().distinct().collect(Collectors.toList());
            return results;
        }
    }
}
