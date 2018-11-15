package leetcode.子集_组合_序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        candidates = new int[]{1, 1, 2, 5};
        List<List<Integer>> list = new Solution().combinationSum2(candidates, 8);
        System.out.println(list);
    }

    static class Solution {
        List<List<Integer>> result;
        int[] candidates;

        List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            result = new ArrayList<>();
            func(target, 0, new ArrayList<>());
            return result;
        }

        void func(int target, int index, List<Integer> temp) {
            if (target == 0) {
                result.add(new ArrayList<>(temp));
            }
            for (int i = index; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    return;
                }
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.add(candidates[i]);
                func(target - candidates[i], i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
