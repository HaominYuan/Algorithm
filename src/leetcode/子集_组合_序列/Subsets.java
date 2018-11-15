package leetcode.子集_组合_序列;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2}));
    }

    static class MySolution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list;
            int pow = (int) Math.pow(2, nums.length);
            for (int i = 0; i < pow; i++) {
                list = new ArrayList<>();
                int s = 1;

                for (int j = 0; j < nums.length; j++) {
                    if ((i & (s << j)) != 0) {
                        list.add(nums[j]);
                    }
                }
                lists.add(new ArrayList<>(list));
                list.clear();
            }
            return lists;
        }
    }

    static class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            func(lists, nums, new ArrayList<>(), 0);
            return lists;
        }

        void func(List<List<Integer>> lists, int[] nums, List<Integer> list, int index) {
            lists.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                func(lists, nums, list, i + 1);
                list.remove(list.size() - 1);
            }
        }


    }
}
