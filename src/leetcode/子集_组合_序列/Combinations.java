package leetcode.子集_组合_序列;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 3));
    }

    static class MySolution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> lists = new ArrayList<>();
            func(n, lists, new ArrayList<>(), 1, k);
            return lists;
        }


        void func(int n, List<List<Integer>> lists, List<Integer> temp, int count, int k) {
            if (k == 0) {
                lists.add(new ArrayList<>(temp));
                return;
            }

            if (count + k - 1 > n) {
                return;
            }




            temp.add(count);
            func(n, lists, temp, count + 1, k - 1);
            temp.remove(temp.size() - 1);
            func(n, lists, temp, count + 1, k);
        }
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> lists = new ArrayList<>();
            func(n, lists, new ArrayList<>(), 1, k);
            return lists;
        }


        void func(int n, List<List<Integer>> lists, List<Integer> temp, int index, int k) {
            if (k == 0) {
                lists.add(new ArrayList<>(temp));
                return;
            }


            for (int i = index; i <= n; i++) {
                if (i + k - 1 > n) {
                    return;
                }
                temp.add(i);
                func(n, lists, temp, i + 1, k - 1);
                temp.remove(temp.size() - 1);
            }
        }
    }



}
