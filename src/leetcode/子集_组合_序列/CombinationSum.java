package leetcode.子集_组合_序列;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> aList : list) {
            System.out.println(aList);
        }
    }


    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            func(result, candidates, target, 0, new ArrayList<>());
            return result;
        }

        void func(List<List<Integer>> lists, int[] candidates, int target, int index, List<Integer> temp) {
            if (target == 0) {
                lists.add(new ArrayList<>(temp));
            }
            for (int i = index; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    return;
                }
                temp.add(candidates[i]);
//                因为可以是重复被选所以 i 不需要加一
                func(lists, candidates, target - candidates[i], i, temp);
                temp.remove(temp.size() - 1);

            }
        }

    }
}
