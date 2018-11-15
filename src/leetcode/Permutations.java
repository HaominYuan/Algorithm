package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{0, 0, 0}));
    }

    static class Solution {
        List<List<Integer>> list;
        public List<List<Integer>> permute(int[] nums) {
            list = new ArrayList<>();
            func(nums, 0, new ArrayList<Integer>());
            return list;
        }

        void func(int[] nums, int index, List<Integer> list) {
            if (list.size() == nums.length) {
                this.list.add(list);
            }
            for (int i = index; i < nums.length; i++) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);
                swap(nums, index, i);
                func(nums, index + 1, temp);
                swap(nums, index, i);
            }
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
