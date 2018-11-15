package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 5));
        System.out.println(new Solution().getPermutation(4, 9));
    }

    static class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> list = new ArrayList<>();
            int temp = 1;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    list.add(temp);
                } else {
                    temp = temp * i;
                    list.add(temp);
                }
            }

            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = i + 1;
            }

            for (int i = n - 1, j = 0; i > 0; i--, j++) {
                temp = (k - 1) / list.get(i);
                if (temp != 0) {
                    int anInt = ints[j];
                    ints[j] = ints[j + temp];
                    ints[j + temp] = anInt;
                    Arrays.sort(ints, j + 1, ints.length);
                }
                k = k - temp * list.get(i);
            }

            String s = "";
            for (int i = 0; i < n; i++) {
                s = s + ints[i];
            }


            return s;
        }
    }
}
