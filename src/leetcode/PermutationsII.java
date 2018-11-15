package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
//        int[] temp = new int[]{2, 3, 1, 4};
//        Arrays.sort(temp, 0, 3);
//        System.out.println(Arrays.toString(temp));
        System.out.println(new Solution().permuteUnique(new int[]{2, 2, 1, 1}));

    }

    static class Solution {
        List<List<Integer>> list;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            list = new ArrayList<>();
            func(nums, 0, new ArrayList<>());
            return list;
        }

        void func(int[] nums, int index, List<Integer> list) {
            if (list.size() == nums.length) {
                this.list.add(list);
            } else {
                for (int i = index; i < nums.length; i++) {
                    if (!(i > index && nums[i] == nums[i - 1])) {
                        ArrayList<Integer> temp = new ArrayList<>(list);
                        temp.add(nums[i]);
                        swap(nums, index, i);
                        Arrays.sort(nums, index + 1, nums.length);
                        func(nums, index + 1, temp);
                        Arrays.sort(nums, index, nums.length);
                    }
                }
            }


        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
