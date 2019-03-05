package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Collections.singletonList(2)));
        lists.add(new ArrayList<>(Arrays.asList(3, 4)));
        lists.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        lists.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(new Solution().minimumTotal(lists));
    }

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] state = new int[triangle.size() + 1];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                List<Integer> list = triangle.get(i);
                for (int j = 0; j < list.size(); j++) {
                    state[j] = Math.min(state[j], state[j + 1]) + list.get(j);
                }
            }
            return state[0];
        }
    }
}
