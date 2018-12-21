package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        ints = new int[]{0, 0, 0, 0};
        System.out.println(Solution.threeSum(ints));
    }


    static class Solution {
        static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> lists = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                int target = -nums[i];
                if (!set.contains(target)) {
                    set.add(target);
                    HashSet<Integer> hashSet = new HashSet<Integer>();
                    for (int j = i + 1; j < nums.length; j++) {
                        if (!hashSet.contains(nums[j])) {
                            hashSet.add(-nums[i] - nums[j]);
                        } else {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(-nums[i] - nums[j]);
                            list.add(nums[j]);
                            lists.add(list);
                        }
                    }
                }
            }
            lists = lists.stream().distinct().collect(Collectors.toList());
            return lists;
        }
    }
}
