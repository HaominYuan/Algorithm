package leetcode;

import java.util.Arrays;

public class SortArrayByParityII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            for (int i = 0, j = 1; i < A.length - 1; i = i + 2) {
                if ((A[i] & 1) != 0) {
                    while ((A[j] & 1) != 0) {
                        j = j + 2;
                    }
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
            return A;
        }
    }
}
