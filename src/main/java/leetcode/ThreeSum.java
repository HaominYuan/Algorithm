package leetcode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(MySolution.threeSum(nums));
    }


    static class MySolution {
        static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists = new LinkedList<>();
            Arrays.sort(nums);
            func(nums, lists, new ArrayList<>(), 0);
            return lists;
        }

        private static void func(int[] nums, List<List<Integer>> lists, List<Integer> list, int index) {
            if (list.size() == 3) {
                int sum = 0;
                for (Integer integer : list) {
                    sum = sum + integer;
                }
                if (sum == 0) {
                    lists.add(new ArrayList<>(list));
                }
                return;
            }


            for (int i = index; i < nums.length; i++) {
                if (i == index || nums[i] != nums[i - 1]) {
                    list.add(nums[i]);
                    func(nums, lists, list, i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> res = new LinkedList<>();
            // 第一层指针
            for (int i = 0; i < num.length - 2; i++) {
                // 最开始的元素或者和前一个不一样的元素才能作为第一个元素
                if (i == 0 || num[i] != num[i - 1]) {
                    // 问题转换为两个元素加起来等于第一个元素的负号
                    int left = i + 1, right = num.length - 1, sum = -num[i];
                    while (left < right) {
                        if (num[left] + num[right] == sum) {
                            res.add(Arrays.asList(num[i], num[left], num[right]));
                            while (left < right && num[left] == num[left + 1]){
                                left++;
                            }
                            while (left < right && num[right] == num[right - 1]) {
                                right--;
                            }
                            left = left + 1;
                            right = right - 1;
                        } else if (num[left] + num[right] < sum) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return res;
        }
    }
}
