package leetcode.子集_组合_序列;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 9));
    }


    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> lists = new ArrayList<>();
            func(lists, new ArrayList<>(), 1, k, n);
            return lists;
        }

        void func(List<List<Integer>> lists, List<Integer> list, int index, int k, int n) {
            if (n < 0) {
                return;
            }

            if (k == 0) {
                if (n == 0) {
                    lists.add(new ArrayList<>(list));
                } else {
                    return;
                }
            }


            for (int i = index; i < 10; i++) {

                list.add(i);
                func(lists, list, i + 1, k - 1, n - i);
                list.remove(list.size() - 1);
            }
        }
    }
}
